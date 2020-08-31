package com.example.demo.event;

public class Door {

    private String state = "";
    private String name = "";
    private DoorStateListener doorStateListener;
    private DoorNameListener doorNameListener;

    public String getState() {
        return state;
    }

    public void setState(String newState) {
//        this.state = state;
        if (state != newState) {
            state = newState;
            if (doorStateListener != null) {
                DoorEvent event = new DoorEvent(this, "state", newState);
                doorStateListener.doorEvent(event);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
//        this.name = name;
        if (name != newName) {
            name = newName;
            if (doorNameListener != null) {
                DoorEvent doorEvent = new DoorEvent(this, "name", newName);
                doorNameListener.doorEvent(doorEvent);
            }
        }
    }

    public DoorStateListener getDoorStateListener() {
        return doorStateListener;
    }

    public void setDoorStateListener(DoorStateListener doorStateListener) {
        this.doorStateListener = doorStateListener;
    }

    public DoorNameListener getDoorNameListener() {
        return doorNameListener;
    }

    public void setDoorNameListener(DoorNameListener doorNameListener) {
        this.doorNameListener = doorNameListener;
    }
}
