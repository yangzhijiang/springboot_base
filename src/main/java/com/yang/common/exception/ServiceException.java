package com.yang.common.exception;

public class ServiceException extends SysException{

    public ServiceException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public ServiceException(int code, String message) {
        super(code, message);
    }

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
