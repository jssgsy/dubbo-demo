package com.univ.service;

import java.util.Map;

/**
 * 用来测试获取消费端往RpcContext注入的attachment
 * @author univ
 * 2021/10/12 3:46 下午
 */
public interface RpcContextService {

    Map<String, String> getAttachment();
}
