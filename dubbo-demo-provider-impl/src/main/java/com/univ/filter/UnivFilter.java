package com.univ.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * @author univ
 * @date 2020/11/3 5:35 下午
 * @description 自定义filter
 */
@Activate(group = {"provider"}, order = -10000000)   // 使此Filter自动激活，并指定顺序为前面
public class UnivFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("进入到自定义的filter方法中了");
        return invoker.invoke(invocation);
    }

    public UnivFilter() {
        // 若是忘了实例化时机(应用启动)，在这里打个断点观察观察调用链
        System.out.println("自定义的filter实例化了");
    }
}
