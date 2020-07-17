package com.example.demo.exception;

public class BusinessExcepption extends GenericException {

    public BusinessExcepption(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessExcepption(String message) {
        super(message);
        this.errorMessage = message;
    }

    public BusinessExcepption(Exception ex) {
        super(ex);
    }

    public BusinessExcepption(Throwable throwable) {
        super(throwable);
    }

    public BusinessExcepption(String message, Exception ex) {
        super(message, ex);
        this.errorMessage = message;
    }

    public BusinessExcepption(String message, Throwable throwable) {
        super(message, throwable);
        this.errorMessage = message;
    }
}
