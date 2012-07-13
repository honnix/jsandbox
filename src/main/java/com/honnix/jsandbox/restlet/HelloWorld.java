package com.honnix.jsandbox.restlet;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class HelloWorld implements Serializable {
    private static final long serialVersionUID = 1495139603674479873L;

    private String world = "Hello World!";

    private Date time = Calendar.getInstance().getTime();

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HelloWorld [world=" + world + ", time=" + time + "]";
    }
}
