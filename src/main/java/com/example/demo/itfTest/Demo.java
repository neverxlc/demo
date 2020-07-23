package com.example.demo.itfTest;

public class Demo {


    public static void main(String[] args) {

        int a = -10;
        int b = 2147483647;//-2147483648   2147483647
        System.out.printf("a输出%d", Math.abs(a));
        System.out.println();
        System.out.printf("b输出%d", Math.abs(b));
    }
}
