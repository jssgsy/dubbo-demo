package com.univ.common.response;

import java.io.Serializable;

import lombok.Data;

/**
 * @author univ
 * @date 2019/4/2 2:18 PM
 * @description 通用返回结构-基类
 */
@Data
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 4519647312292152969L;

    /**
     * 此次请求是否成功
     */
    protected Boolean success;

    protected String message;
}
