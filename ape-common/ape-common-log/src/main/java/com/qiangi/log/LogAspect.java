package com.qiangi.log;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 日志的切面类
 */
@Aspect
@Slf4j
@Component
@ConditionalOnProperty(name = {"log.aspect.enable"}, havingValue = "true", matchIfMissing = true)
public class LogAspect {

    @Pointcut("execution(* com.qiangi.*.controller.*Controller.*(..)) || execution(* com.qiangi.*.service.*Service.*(..))")
    private void pointCut() {
    }

//    @Around("pointCut()")
//    public void around(ProceedingJoinPoint pjp) throws Throwable {
//        Object[] reqArgs = pjp.getArgs();
//        String req = new Gson().toJson(reqArgs);
//        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//        String methodName = methodSignature.getDeclaringType().getName() + "." + methodSignature.getName();
//        log.info("{},req:{}", methodName, req);
//        Long startTime = System.currentTimeMillis();
//        Object responseObj = pjp.proceed();
//        String resp = new Gson().toJson(responseObj);
//        Long endTime = System.currentTimeMillis();
//        log.info("{},response:{},costTime:{}", methodName, resp, endTime - startTime);
//    }

    /**
     * 将之前的方法进行添加返回值,否则进行测试时,apifox无法进行获取到方法的返回值
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] reqArgs = pjp.getArgs();
        String req = new Gson().toJson(reqArgs);
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String methodName = methodSignature.getDeclaringType().getName() + "." + methodSignature.getName();
        log.info("{},req:{}", methodName, req);

        long startTime = System.currentTimeMillis();
        Object responseObj = pjp.proceed(); // 必须接收返回值
        long endTime = System.currentTimeMillis();

        String resp = new Gson().toJson(responseObj);
        log.info("{},response:{},costTime:{}", methodName, resp, endTime - startTime);

        return responseObj; // ✅ 返回结果！
    }
    //扩展的使用:可以将用户的信息,数据变更的记录都可以进行使用切面进行记录到数据库或者是文件中


}
