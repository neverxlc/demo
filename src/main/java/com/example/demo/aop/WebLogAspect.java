package com.example.demo.aop;

import com.mongodb.BasicDBObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * http://blog.didispace.com/springbootaoplog/
 *
 * 使用@Aspect注解将一个java类定义为切面类
 * 使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
 * 根据需要在切入点不同位置的切入内容
 * 使用@Before在切入点开始处切入内容
 * 使用@After在切入点结尾处切入内容
 * 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
 * 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
 * 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
 *
 *
 *
 * 定义每个切面的优先级，我们需要@Order(i)注解来标识切面的优先级。i的值越小，优先级越高。
 * 在切入点前的操作，按order的值由小到大执行
 * 在切入点后的操作，按order的值由大到小执行
 */
@Aspect
@Component
public class WebLogAspect {

//    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    private Logger logger = Logger.getLogger("mongodb");


    // 同步问题 ThreadLocal
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(* com.example..controller..*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        //
        startTime.set(System.currentTimeMillis());
        // 接受到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下去请求的内容
        logger.info("URL : " + request.getRequestURI());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() +
                "." +joinPoint.getSignature().getDeclaringTypeName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        // 获取要记录的日志内容
        BasicDBObject logInfo = getBasicDBObject(request, joinPoint);
        logger.info(logInfo);
    }



//    @AfterReturning("webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + ret);
//        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//    }



    private BasicDBObject getBasicDBObject(HttpServletRequest request, JoinPoint joinPoint) {
        // 基本信息
        BasicDBObject r = new BasicDBObject();
        r.append("requestURL", request.getRequestURL().toString());
        r.append("requestURI", request.getRequestURI());
        r.append("queryString", request.getQueryString());
        r.append("remoteAddr", request.getRemoteAddr());
        r.append("remoteHost", request.getRemoteHost());
        r.append("remotePort", request.getRemotePort());
        r.append("localAddr", request.getLocalAddr());
        r.append("localName", request.getLocalName());
        r.append("method", request.getMethod());
        r.append("headers", getHeadersInfo(request));
        r.append("parameters", request.getParameterMap());
        r.append("classMethod", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        r.append("args", Arrays.toString(joinPoint.getArgs()));
        return r;
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
