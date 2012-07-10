package com.honnix.jsandbox.aspectj.figure;

public class Line {
    private Point start;

    private Point end;

    public Line(Point start, Point end) {
        super();

        this.start = start;
        this.end = end;
    }

    public void rotate(int degree) {
        start.setX(start.getX() * degree);
        start.setY(start.getY() * degree);
    }
}
