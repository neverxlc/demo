package com.example.demo.vo;

import org.springframework.boot.system.JavaVersion;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class BaseReponse implements Serializable {

    private ResponseHeader responseHeader = new ResponseHeader();

    public BaseReponse() {
    }

    public BaseReponse(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public static BaseReponse ok() {
        return new BaseReponse();
    }

    public static BaseReponse failure(String resultCode, String resultMessage){
        ResponseHeader responseHeader = new ResponseHeader(false, resultCode, resultMessage);
        return new BaseReponse(responseHeader);
    }


    private static final AtomicIntegerArray ID = new AtomicIntegerArray(18);
    public static void main(String[] args) {


//        JavaVersion.getJavaVersion().name();
        System.out.println(JavaVersion.getJavaVersion().toString());
        /*String queryParam = "name=xlc&age=20&sex=man";
        StringTokenizer stringTokenizer = new StringTokenizer(queryParam,"&");
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            System.out.println(token);
        }*/


//        System.out.println(ID.getAndIncrement(1));
//        System.out.println(ID.getAndIncrement(1));
//        System.out.println(ID.getAndIncrement(1));
//        System.out.println(ID.getAndIncrement(1));
//        System.out.println(ID.getAndIncrement(2));
//        System.out.println(ID.getAndIncrement(2));
//
//        System.out.println(ID.getAndIncrement(2));

    }
}
