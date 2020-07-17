package com.example.demo.vo;

import java.io.Serializable;
import java.util.function.Function;
import java.util.function.Supplier;

public class ResponseHeader implements Serializable {

    private boolean isSuccess = true;
    private String resultCode;
    private String resultMessage;
    private String info;

    public ResponseHeader() {
    }

    public ResponseHeader(boolean isSuccess, String resultCode, String resultMessage) {
        this.isSuccess = isSuccess;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }


    public ResponseHeader(boolean isSuccess, String resultCode, String resultMessage, String info) {
        this.isSuccess = isSuccess;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.info = info;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public static void main(String[] args) {


        System.out.println(Person.sayHi(()->{
            return "nihao";
        }));

        System.out.println(Person.convert("12312312",(e)->{
            return Integer.valueOf(e.substring(1));
        }));

        System.out.println(Person.convert("12312312",k -> Integer.valueOf(k.substring(1))));
    }


    public static class Person{

        private static String sayHi(Supplier<String> supplier){
            return supplier.get();
        }
        private static Integer convert(String num, Function<String,Integer> function) {
            return function.apply(num);
        }
    }
}
