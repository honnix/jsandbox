package com.honnix.jsandbox.aspectj.figure;

public class NamedPoint extends Point {
    private String name;

    public NamedPoint(String name) {
        super();

        this.setName(name);
    }

    public NamedPoint(String name, int x, int y) {
        super(x, y);

        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getX() {
        return 1;
    }

    @Override
    public void setX(int x) {
    }

    @Override
    public int getY() {
        return 1;
    }

    @Override
    public void setY(int y) {
    }

    @Override
    public String toString() {
        return "NamedPoint [name=" + name + ", getX()=" + getX() + ", getY()=" + getY() + "]";
    }
}
