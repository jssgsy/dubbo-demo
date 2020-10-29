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
        

