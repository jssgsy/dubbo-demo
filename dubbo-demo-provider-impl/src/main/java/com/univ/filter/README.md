# 自定义Filter---how to
参见UnivFilter.java。总共只需要两步。
## 定义一个Filter并实现dubbo的Filter接口
```
@Activate(group = {"provider"})   // 使此Filter自动并激活,被@Activate修饰则和原生filter同等对待了
public class UnivFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("进入到自定义的filter方法中了");
        return invoker.invoke(invocation);
    }
}
```
## 用@Activate修饰自定义的Filter以启用
* 也可以通过配置文件的方式；

# 备忘
* 用@Activate修饰的自定义的Filter的实例化过程和原生的Filter是一样的；

# Q&A
## filter扩展点为何要放在META-INF/dubbo目录下？
不一定非为`META-INF/dubbo`目录，也可以为`META-INF/dubbo/internal`也可以为`META-INF/services`目录。（均经过验证）
真相都在ExtensionLoader.java中
```
private static final String SERVICES_DIRECTORY = "META-INF/services/";
private static final String DUBBO_DIRECTORY = "META-INF/dubbo/";
private static final String DUBBO_INTERNAL_DIRECTORY = DUBBO_DIRECTORY + "internal/";
```

## filter扩展点的配置文件名为何必须为com.alibaba.dubbo.rpc.Filter？
这就涉及到扩展点是何时被加载的。参见ExtensionLoader.java的loadFile方法。
```
private void loadFile(Map<String, Class<?>> extensionClasses, String dir) {
    // 这里的type是ExtensionLoader的成员变量，
    // 也是当前扩展点的class，而filter扩展点Filter类在dubbo中就是com.alibaba.dubbo.rpc.Filter！
    String fileName = dir + type.getName(); 
    // 其它
}
```

## 如何指定Filter的顺序？
直接使用@Activate的order属性即可，数字越小，此Filter越排在调用链的前面。
参见ExtensionLoader.java#getActivateExtension方法。如下：
```
// exts:在filter的上下文中即为各个具体的Filters，filter的排序秘密就在ActivateComparator中
Collections.sort(exts, ActivateComparator.COMPARATOR);
```

## filter的配置文件是否可以写注释？
可以，注释以`#`开头即可。参见ExtensionLoader.java#loadFile方法
```
// ...
while ((line = reader.readLine()) != null) {
    final int ci = line.indexOf('#');   // 处理以#开头的注释
    if (ci >= 0) line = line.substring(0, ci);  // 获取注释之前的配置(说明可以注释和配置可以写在同一行，如：ext=com.univ.Extension #这里注释)
    line = line.trim();
    if (line.length() > 0) {    // 开始处理正文
        // ...
    }
}
// ...
```

## filter的配置文件的其它写法
* =号之前的名称以逗号分隔
```
# 注释还是可以写的，注释以#开关
univ,univ2=com.univ.filter.UnivFilter
```
但似乎没什么用，且只影响到cachedNames的赋值。参见ExtensionLoader.java#loadFile方法
```
for (String n : names) { // 按逗号分隔解析出来的，这里即为[univ, univ2]
    if (! cachedNames.containsKey(clazz)) { // 存在的话就忽略了，即只处理了names[0]
        cachedNames.put(clazz, n);
    }
}
```