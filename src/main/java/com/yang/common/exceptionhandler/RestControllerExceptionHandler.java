package com.yang.common.exceptionhandler;

import com.yang.common.exception.RestControllerException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestControllerExceptionHandler {

    @ExceptionHandler(RestControllerException.class)
    public Map<String,Object> exception(Exception e){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code","fail");
        result.put("mes",e.getMessage());
        return result;
    }

}
