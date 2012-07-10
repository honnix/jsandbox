package com.honnix.jsandbox.aspectj.figure;

public class Figure {
    public static void main(String[] args) {
        Screen s = new Screen();
        Point p = new Point();
        PointObserving.addObserver(p, s);
        
//        p.setX(1);
//        p.setY(2);
//        
//        Point start = new Point(1, 2);
//        Point end = new Point(4, 5);
//        Line line = new Line(start, end);
//        line.rotate(1);
//        line.rotate(2);
//        line.rotate(3);
//        line.rotate(4);
//        
//        System.out.println(SetsInRotateCounting.aspectOf().rotateCount);
//        System.out.println(SetsInRotateCounting.aspectOf().setCount);
        
        NamedPoint point = new NamedPoint("point", 1, 1);
        point.setX(2);
    }
}
