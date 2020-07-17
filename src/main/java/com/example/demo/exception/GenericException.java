package com.example.demo.exception;

import java.io.Serializable;

public class GenericException extends RuntimeException implements Serializable {

    String errorCode;
    String errorMessage;


    public GenericException() {
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(Exception exception) {
        super(exception);
    }

    public GenericException(Throwable cause) {
        super(cause);
    }

    public GenericException(String message, Exception exception) {
        super(message,exception);
    }

    public GenericException(String message,Throwable throwable) {
        super(message, throwable);
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
