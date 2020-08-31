package com.example.demo.event;

import java.util.EventListener;

public class DoorStateListener implements EventListener {

    public void doorEvent(DoorEvent doorEvent){
        if (doorEvent.getValue() != null && doorEvent.getValue().equals("open")) {
            System.out.println("门已打开");
        } else {
            System.out.println("门已关闭");
        }
    }
}
