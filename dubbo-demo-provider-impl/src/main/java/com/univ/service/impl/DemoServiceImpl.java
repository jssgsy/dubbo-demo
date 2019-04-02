package com.univ.service.impl;

import com.univ.common.exception.UnivException;
import com.univ.common.response.SingleResult;
import com.univ.common.util.response.ResultUtil;
import com.univ.service.DemoService;

/**
 * Univ
 * 16/7/5 14:39
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public SingleResult<String> getAddress() {
        return ResultUtil.wrapSingle("湖北武汉");
    }

    @Override
    public SingleResult<String> throwException() {
        throw new UnivException("这是UnivException异常");
    }

}
