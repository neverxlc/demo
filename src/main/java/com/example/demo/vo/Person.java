package com.example.demo.vo;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Person person = new Person();
        person.setId(2);
        person.setName("xlc");
        List<Person> list = new ArrayList<>();

        list.add(person);
        System.out.println(list);
    }


    public static void main1(String[] args) {
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
