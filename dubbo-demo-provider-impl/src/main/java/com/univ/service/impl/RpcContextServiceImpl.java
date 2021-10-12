package com.univ.service.impl;

import java.util.Map;

import com.alibaba.dubbo.rpc.RpcContext;
import com.univ.service.RpcContextService;

/**
 * @author univ
 * 2021/10/12 3:47 下午
 */
public class RpcContextServiceImpl implements RpcContextService {

    @Override
    public Map<String, String> getAttachment() {
        Map<String, String> attachments = RpcContext.getContext().getAttachments();
        System.out.println("从消费端设置的attachment中的key1为：" + attachments.get("key1"));
        System.out.println("从消费端设置的attachment中的key2为：" + attachments.get("key2"));
        return attachments;
    }
}
