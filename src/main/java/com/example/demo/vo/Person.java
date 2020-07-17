package com.example.demo.vo;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                '}';
    }


    public static void main(String[] args) {
//        long a = 100;
//        if (a < 0) {
//            System.out.println("aaaaa");
//        } else {
//            System.out.println("bbb");
//        }

        List<String> list = new ArrayList<>();
        list.add("aaa");
        System.out.println(list.get(1));
    }
}
