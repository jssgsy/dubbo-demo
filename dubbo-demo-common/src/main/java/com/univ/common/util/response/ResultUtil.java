package com.univ.common.util.response;

import com.univ.common.response.SingleResult;

/**
 * @author univ
 * @date 2019/4/2 2:15 PM
 * @description 用来包装provider统一的返回结构
 */
public class ResultUtil {

    public static <T> SingleResult wrapSingle(T t) {
        SingleResult<T> singleResult = new SingleResult<>(t);
        singleResult.setSuccess(true);
        return singleResult;
    }

    public static SingleResult<String> wrapException(Throwable ex) {
        SingleResult<String> singleResult = new SingleResult<>(ex.getMessage());
        singleResult.setSuccess(false);
        return singleResult;
    }
}
