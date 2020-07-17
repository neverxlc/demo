package com.example.demo.spi;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public final class IdGenUtil {

    public static String getHexIdStr(){

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        long time = timestamp.getTime()<<1;
        String s = Integer.toHexString((int)time);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println(Timestamp.valueOf(LocalDateTime.now()).getTime());
        System.out.println(getHexIdStr());
    }
}
