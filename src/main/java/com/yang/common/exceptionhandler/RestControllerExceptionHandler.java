package com.yang.common.exceptionhandler;

import com.yang.common.constants.ErrCodeConstant;

import com.yang.common.exception.ServiceException;
import com.yang.common.exception.SysException;
import com.yang.common.globalbean.ApiResult;
import com.yang.common.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(RestControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ApiResult exception(Exception e){

        int code = 0;
        String message = "未知异常";

        e.printStackTrace();
        if(e instanceof ServiceException){

            ServiceException ex = (ServiceException) e;
            code = ex.getCode();
            message = ex.getMessage();
            logger.error(LogUtil.logFormat("服务异常信息：[code:%s,message:%s,stacktrace:%s]",ex.getCode(),ex.getMessage(),ex.getStackTrace()));
            return ApiResult.fail(code,e.getMessage());

        }else if(e instanceof SysException){

            SysException se = (SysException) e;
            code = ErrCodeConstant.SYS_ERROR_CODE;
            logger.error(LogUtil.logFormat("自定义系统异常信息：[code:%s,message:%s,stacktrace:%s]",se.getCode(),se.getMessage(),se.getStackTrace()));
        }else{

            logger.error(LogUtil.logFormat("系统异常信息：[code:%s,message:%s,stacktrace:%s]",code,e.getMessage(),e.getStackTrace()));

        }

        return ApiResult.fail(code,message);

    }

}
