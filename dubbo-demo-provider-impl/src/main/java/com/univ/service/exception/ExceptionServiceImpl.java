package com.univ.service.exception;

import com.univ.common.exception.UnivException;
import com.univ.common.response.SingleResult;
import com.univ.service.ExceptionService;

/**
 * @author univ
 * @date 2019/11/29 2:50 PM
 * @description
 */
public class ExceptionServiceImpl implements ExceptionService {

    /**
     * 实现类不用throws UnivException
     * @return
     */
    @Override
    public SingleResult<String> throwException() {
        throw new UnivException("抛自定义异常了，因为接口签名有声明抛出异常，因此抛出的是自定义异常");
    }

    @Override
    public SingleResult<String> originalException() {
        throw new UnivException("originalException-抛自定义异常了，没有任何处理的异常则层层上传导致调用中断");
    }
}
