package com.univ;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcException;
import com.univ.dto.validation.ValidateDTO;
import com.univ.service.DemoService;
import com.univ.service.ValidateService;

/**
 * Univ
 * 16/7/5 14:46
 */

/**
 * 服务消费者
 */
public class Consumer {

    /**
     * 消费服务提供者
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-consumer.xml"});
        context.start();

        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法

        System.out.println(hello);
    }

    /**
     * dubbo-参数校验
     */
    @Test
    public void validate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-consumer.xml"});
        context.start();

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
}
