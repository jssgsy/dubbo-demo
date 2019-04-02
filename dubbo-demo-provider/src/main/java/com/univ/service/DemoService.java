package com.univ.service;

import com.univ.common.response.SingleResult;

/**
 * Created by Univ on 16/7/5.
 */
public interface DemoService {

    String sayHello(String name);

    SingleResult<String> getAddress();

    SingleResult<String> throwException();
}
