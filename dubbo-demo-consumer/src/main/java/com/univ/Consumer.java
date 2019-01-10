package com.univ;

import com.univ.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Univ
 * 16/7/5 14:46
 */

/**
 * 服务消费者
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-consumer.xml"});
        context.start();

        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法

        System.out.println(hello);
    }

}
