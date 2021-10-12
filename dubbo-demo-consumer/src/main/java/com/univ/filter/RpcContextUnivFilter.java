package com.univ.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * 消费端的filter
 *
 * 注：所谓消费端的filter，即供消费端使用的filter，因此定义肯定是在消费端
 */
@Activate(group = Constants.CONSUMER)
public class RpcContextUnivFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("自定义的RpcContextUnivFilter执行了");
        return invoker.invoke(invocation);
    }

    public RpcContextUnivFilter() {
        System.out.println("自定义的RpcContextUnivFilter实例化了");
    }
}
