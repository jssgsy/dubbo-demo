package com.univ.common.exception;

/**
 * @author univ
 * @date 2019/4/2 10:38 AM
 * @description dubbo对异常的处理
 * 默认下，dubbo对会provider端的异常进行拦截处理，逻辑参见类com.alibaba.dubbo.rpc.filter.ExceptionFilter
 *
 * 这里演示如何在provider端抛出异常时也有结果返回给consumer端,使用spring aop拦截异常
 */
public class UnivException extends RuntimeException {

    public UnivException(String message) {
        super(message);
    }
}
