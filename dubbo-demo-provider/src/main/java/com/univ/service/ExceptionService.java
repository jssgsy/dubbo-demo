package com.univ.service;

import com.univ.common.exception.UnivException;
import com.univ.common.response.SingleResult;

/**
 * @author univ
 * @date 2019/11/29 2:50 PM
 * @description
 */
public interface ExceptionService {

    /**
     * 服务器端抛出异常，如果这里声明了抛出异常，则当异常抛出时，则抛出的是代码中抛出的自定义异常
     * 而不是整个异常堆栈信息
     * @return
     * @throws UnivException
     */
    SingleResult<String> throwException() throws UnivException;

    /**
     * 服务器端抛出异常，如果不作任何处理，则会将自定义的异常作为message包装成RuntimeException抛出。
     * (抛出的是RuntimeException而不是代码中抛出的自定义异常)
     * @return
     */
    SingleResult<String> originalException();
}
