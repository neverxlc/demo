package com.example.demo.event;

import org.apache.tomcat.jni.OS;

import java.util.*;

public class Demo {


    public static void main1(String[] args) {
        Door door = new Door();
        door.setDoorNameListener(new DoorNameListener());
        door.setDoorStateListener(new DoorStateListener());
        door.setState("open");
        System.out.println("我已经进来了");

        door.setState("close");

        door.setName("xlllc");
    }

    public static void main2(String[] args) {
        System.out.println(OS.IS_WIN64);
        System.out.println(OS.IS_WIN32);
    }

    public static void main(String[] args) {
        List<String> list = new DemoList<>(Arrays.asList("1","2","4"));
//        String.join(",", list);DemoList
//        System.out.println(String.join(",", list));
        long startTime = System.currentTimeMillis();
        for (int i =0 ; i< 100000; i++) {
//                System.out.println(list);
//            list.toString();
        }
        // 100 5
        // 1000 40
        // 10000 240
        // 100000 1474 70

        //  1000 36
        // 10000 375
//        100000 1370
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static class DemoList<E> extends ArrayList<E> {


        public DemoList(List<E> asList) {
            super(asList);
        }

        @Override
        public String toString() {
            Iterator<E> it = iterator();
            if (! it.hasNext())
                return "";
            StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
//            StringJoiner stringJoiner = new StringJoiner(",");
            while (it.hasNext()) {
                stringJoiner.add((CharSequence) it.next());
            }
            return stringJoiner.toString();
        }

        //        @Override
//        public String toString() {
//            Iterator<E> it = iterator();
//            if (! it.hasNext())
//                return "";
//
//            StringBuilder sb = new StringBuilder();
////            sb.append('');
//            for (;;) {
//                E e = it.next();
//                sb.append(e == this ? "(this Collection)" : e);
//                if (! it.hasNext())
//                    return sb.toString();
//                sb.append(',').append(' ');
//            }
//        }
    }
}
