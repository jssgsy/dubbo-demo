# dubbo-demo

# 启动方法：
1. **需要先启动本地zookeeper服务**
  /Users/Univ/Downloads/zookeeper-3.3.6/bin/zkServer.sh start
2. 注册服务：运行com.univ.ProviderStart.main方法；
3. 引用服务：运行com.univ.Consumer.main方法；


# 使用参数校验功能
* 依赖的引入(hibernate-validator,javax.el-api，放在对外dubbo-demo-provider模块上即可)
* 消费者引入远程服务提供者bean时需要指定validation属性为true，(经验证，服务提供者暴露服务时不用)
> <dubbo:reference interface="com.univ.service.ValidateService" id="validateService" validation="true"/>
* 在dto中添加限制(@NotNull,@Email等等)

# dubbo异常
当服务端抛出异常时，
1. 如果调用方不进行捕获，则调用方调用链断掉(异常会层层往上传递)；
2. 如果调用方进行了捕获，则捕获到的message是可能整个服务端的异常堆栈，而不是服务端所抛异常的message！(视服务端的处理而定)

注：
如果在服务端dubbo接口方法处声明了会抛出异常，则当抛出异常时，此时返回的异常的message便为服务端抛出异常的message(可参见源码ExceptionFilter.java)。
这也是一种好的编码习惯，在方法签名上指定可能抛出的异常；