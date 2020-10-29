package com.univ;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.univ.common.response.SingleResult;
import com.univ.dto.validation.ValidateDTO;
import com.univ.service.DemoService;
import com.univ.service.ExceptionService;
import com.univ.service.ValidateService;

/**
 * Univ
 * 16/7/5 14:46
 */

/**
 * 服务消费者
 */
public class Consumer {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-consumer.xml"});

    @Before
    public void setUp() throws Exception {
        context.start();
    }

    /**
     * 消费服务提供者
     */
    @Test
    public void consumerService() {
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println(hello);
    }

    /**
     * dubbo-参数校验
     * , 但服务端和消费端必须指定一个validation="true"，否则不验证。
     */
    @Test
    public void validate() {
        ValidateService validateService = (ValidateService)context.getBean("validateService"); // 获取远程服务代理
        try {
            // 基本类型的校验
            ValidateDTO validateDTO = validateService.getById(2l);
            System.out.println(validateDTO);

            // 对象类型的校验
            ValidateDTO v2 = new ValidateDTO();
            v2.setId(30l);
            v2.setName("univ");

            String result = validateService.getByValidateDTO(v2);
            System.out.println(result);
        } catch (RpcException exception) {  // 注意，所以实现者的异常最终都会被包装成RpcException抛出
            System.out.println("没有通过验证：" + exception.getMessage());
        }
    }

    /**
     * 查看某个service是否可用
     *
     * 利用所有的远程service都是EchoService的子类
     */
    @Test
    public void echoService() {
        ValidateService validateService = (ValidateService) context.getBean("validateService");
        // 将其转变为EchoService类型即可
        EchoService echoService = (EchoService) validateService;

        // Echo test usability
        String status = (String) echoService.$echo("OK");
        System.out.println(status);
    }

    /**
     * provider返回统一的数据
     */
    @Test
    public void unifiedResult() {
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        SingleResult address = demoService.getAddress();
        System.out.println(address);
    }

    /**
     * 服务器端抛出异常时：
     * 如果不作任何处理(不捕获，不在接口处声明throws异常，异常类和接口类不在同一包下)，则调用方调用链断掉(异常会层层往上传递)，
     * 且会将代码中抛出的异常整个作为message包装成RuntimeException抛出
     */
    @Test
    public void originalException() {
        ExceptionService exceptionService = (ExceptionService) context.getBean("exceptionService");
        // 抛出异常
        SingleResult<String> stringSingleResult = exceptionService.originalException();

        // 注：如果此方法被aop（ResponseAspect）拦截了，则下面还是会执行的
        System.out.println("这行及以下代码不会执行");
        System.out.println("异常message: " + stringSingleResult.getMessage());
    }

    /**
     * 如果服务端dubbo接口声明了throws异常，则抛出的就是代码中自定义的异常
     */
    @Test
    public void originalExceptionV2() {
        ExceptionService exceptionService = (ExceptionService) context.getBean("exceptionService");
        exceptionService.throwException();
    }

    /**
     * provider抛出异常时返回统一的数据
     */
    @Test
    public void handleException() {
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        SingleResult remoteResult = demoService.throwException();
        System.out.println(remoteResult);
    }
}
