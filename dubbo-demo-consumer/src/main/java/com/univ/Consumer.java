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
     * 注意，当服务端抛出异常时，
     * 1. 如果调用方不进行捕获，则调用方调用链断掉(异常层层往上传递)；
     * 2. 如果调用方进行了捕获，则捕获到的message是可能整个服务端的异常堆栈，而不是服务端所抛异常的message！(视服务端的处理而定)
     */
    @Test
    public void originalException() {
        ExceptionService exceptionService = (ExceptionService) context.getBean("exceptionService");
        try {
            exceptionService.throwException();
        } catch (Exception ex) {
            System.out.println("dubbo服务端抛出异常的message为：" + ex.getMessage());
        }
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
