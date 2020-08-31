package com.example.demo.event;

import java.util.EventObject;

public class DoorEvent extends EventObject {

    private final String key;

    private final String value;

    public DoorEvent(Object source, String key, String value) {
        super(source);
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
