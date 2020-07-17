package com.example.demo.interceptor;

import com.example.demo.exception.BusinessExcepption;
import com.example.demo.vo.BaseReponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice(annotations = {Controller.class})
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @ResponseBody
    @ExceptionHandler({BusinessExcepption.class})
    public BaseReponse HandlerException(BusinessExcepption e){
//        log.info(e.getErrorCode(), e.getErrorMessage());
        System.err.println(e);
//        LOGGER.info(e.getMessage());
        return BaseReponse.failure(e.getErrorCode(), e.getErrorMessage());
    }
}
