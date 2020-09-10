package com.example.demo.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class ParamAspect {

    public ParamAspect() {

    }

    @Around("execution(* com.example..controller..*(..))")
    public Object microServiceAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        return this.execute(proceedingJoinPoint);
    }

//    public Object appServiceAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
////
////        return this.execute(proceedingJoinPoint)
////    }


    private Object execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        String reqSrv = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String reqMethodName = method.getName();
        Object[] args = proceedingJoinPoint.getArgs();
        String strReqArgs = null;
        if (args == null || args.length == 0) {
            strReqArgs = "";
        } else {
            strReqArgs = JSONObject.toJSONString(args);
        }
        System.err.println(String.format("请求服务：{%s}，请求方法：{%s},请求参数：{%s}", reqSrv, reqMethodName, strReqArgs));
//        if(log.isInfoEnabled()) {
//            log.info("请求服务：{}，请求方法：{},请求参数：{}", reqSrv, reqMethodName, strReqArgs);
//        }
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
//            if (log.isErrorEnabled()) {
//                log.error("请求错误");
//            }
            System.out.println(throwable);
            throw throwable;
        }
//        if (log.isInfoEnabled()) {
//            log.info("result={}", result);
//        }
        System.err.println(String.format("result={%s}", result));
        return result;
    }
}
