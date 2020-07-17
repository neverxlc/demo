package com.example.demo.annotation;

import com.example.demo.apo.ParamAspect;
import com.example.demo.interceptor.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({ParamAspect.class})
public @interface EnableParamPrint {
}
