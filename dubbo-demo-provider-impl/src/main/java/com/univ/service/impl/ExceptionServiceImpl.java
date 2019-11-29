package com.univ.service.impl;

import com.univ.common.exception.UnivException;
import com.univ.service.ExceptionService;

/**
 * @author univ
 * @date 2019/11/29 2:50 PM
 * @description
 */
public class ExceptionServiceImpl implements ExceptionService {

    @Override
    public boolean throwException() {
        throw new UnivException("抛自定义异常了，但整个异常会被dubbo包装成message被抛给调用方");
    }
}
