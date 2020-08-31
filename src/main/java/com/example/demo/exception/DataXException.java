package com.example.demo.exception;

import com.example.demo.spi.ErrorCode;

import java.io.PrintWriter;
import java.io.StringWriter;

public class DataXException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    public DataXException(ErrorCode errorCode, String errorMessage) {
        super(errorCode.toString() + " - " +errorMessage);
        this.errorCode = errorCode;
    }

    private DataXException(ErrorCode errorCode, String errorMessage, Throwable throwable) {
        super(errorCode.toString() + " - " + getMessage(errorMessage) + " - " +getMessage(throwable), throwable);
    }



    public static DataXException asDataXException(ErrorCode errorCode, String message) {
        return new DataXException(errorCode, message);
    }

    public static DataXException asDataXException(ErrorCode errorCode, String message, Throwable cause) {
        if (cause instanceof DataXException) {
            return (DataXException) cause;
        }
        return new DataXException(errorCode, message, cause);
    }

    public static DataXException asDataXException(ErrorCode errorCode, Throwable cause) {
        if (cause instanceof DataXException) {
            return (DataXException) cause;
        }
        return new DataXException(errorCode, getMessage(cause), cause);
    }

    public ErrorCode getErrorCode(){
        return this.errorCode;
    }

    private static String getMessage(Object object) {

        if (object == null) {
            return "";
        }
        if (object instanceof Throwable) {

            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            ((Throwable) object).printStackTrace();
//            return printWriter.toString();
            return stringWriter.toString();
        }
        return object.toString();
    }
}
