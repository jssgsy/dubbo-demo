package com.univ.providerimpl;

import com.univ.iprovider.DemoService;

/**
 * Univ
 * 16/7/5 14:39
 */
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "hello " + name;
    }
}
