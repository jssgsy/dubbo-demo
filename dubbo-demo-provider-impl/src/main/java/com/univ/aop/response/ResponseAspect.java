package com.univ.aop.response;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.univ.common.exception.UnivException;
import com.univ.common.util.response.ResultUtil;

/**
 * @author univ
 * @date 2019/4/2 2:46 PM
 * @description 拦截provider中的所有抛出的异常并转换为统一的数据结构返回
 */
// @Component
@Aspect
public class ResponseAspect {

    /**
     * com.univ.service包及其所有子包下的所有方法当作切点
     */
    @Pointcut("execution(* com.univ.service..*.*(..))")
    public void triggerException() {

    }

    /**
     * 不要使用@AfterThrowing，因为抛出异常后还是 最终 会被dubbo的ExceptionFilter给捕获
     *
     * 注：
     *  第一个参数须为ProceedingJoinPoint
     *  返回的是Object类型
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around("triggerException()")
    public Object response(ProceedingJoinPoint proceedingJoinPoint) {
        // 核心：在这里将异常显示catch住，此时便不会被dubbo的ExceptionFilter给捕捉到
        try {
            // 执行目标方法
            return proceedingJoinPoint.proceed();
        } catch (UnivException ex) {
            // 注意：生产环境中这里需要将异常作为日志记录下来，便于定位
            System.out.println("发生了UnivException异常");
            return ResultUtil.wrapException(ex);
        } catch (Throwable throwable) {
            return ResultUtil.wrapException(throwable);
        }
    }
}
