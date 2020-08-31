package com.example.demo.event;

import java.util.EventListener;

public class DoorNameListener implements EventListener {

    public void doorEvent(DoorEvent doorEvent) {
        Door door = (Door) doorEvent.getSource();
        System.out.println("new Name = " +door.getName());
    }
}
