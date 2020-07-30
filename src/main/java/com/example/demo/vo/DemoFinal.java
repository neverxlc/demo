package com.example.demo.vo;

public class DemoFinal {

    private final int a;

    private final boolean b;

    public DemoFinal(int a, boolean b) {
        this.a = a;
        this.b = b;
    }


    public int getA() {
        return a;
    }

    public boolean isB() {
        return b;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        DemoFinal demoFinal = new DemoFinal(1,false);
//        demoFinal.getA();
        System.out.println(demoFinal.getA());
        System.out.println(demoFinal.isB());
        DemoFinal demoFinal1 = (DemoFinal) demoFinal.clone();

        System.out.println(demoFinal);
        System.out.println(demoFinal1);
    }
}
