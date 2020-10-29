# dubbo异常
整个逻辑在：ExceptionFilter.java
当服务端抛出异常时，
1. 如果不作任何处理(不捕获，不在接口处声明throws异常，异常类和接口类不在同一包下)，则调用方调用链断掉(异常会层层往上传递)，且会将代码中抛出的异常整个作为message包装成RuntimeException抛出
2. 在接口处声明throws异常，则抛出的是代码中自定义的异常；

dubbo异常处理最佳实践：
    一般会自定义异常(运行时)，此时如果直接在服务器端抛出，则会抛出RuntimeException，而不是自定义的异常。
    解决的方法：
        1. 自定义Filter介入统一处理Exception;
        2. 使用aop介入统一处理Exception（在dubbo的ExceptionFilter之前，相当于永远不会有异常抛出）;
        
# 流程图
![dubbo异常处理流程](https://github.com/jssgsy/dubbo-demo/raw/master/dubbo-demo-provider-impl/src/main/java/com/univ/service/exception/dubbo异常处理流程.png