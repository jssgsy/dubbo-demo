package com.univ.service;

import com.univ.common.exception.UnivException;

/**
 * @author univ
 * @date 2019/11/29 2:50 PM
 * @description
 */
public interface ExceptionService {

    /**
     * 注意，如果这里声明了抛出异常，则当异常抛出时，调用方catch住的异常的message为这里抛出异常时设置的message，
     * 而不是整个异常堆栈信息
     * @return
     * @throws UnivException
     */
    boolean throwException() throws UnivException;
}
