package com.univ;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Univ
 * 16/7/10 15:43
 */

//在这里启动服务
public class ProviderStart {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-provider.xml");
        context.start();
        System.out.println("服务提供者启动了......");
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }

}
