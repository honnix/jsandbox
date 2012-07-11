package com.honnix.jsandbox.aspectj.figure;

import java.util.Iterator;
import java.util.Vector;

public privileged aspect PointObserving {
    private Vector<Screen> Point.observers = new Vector<Screen>();
    
    public static void addObserver(Point p, Screen s) {
        p.observers.add(s);
    }
    
    public static void removeObserver(Point p, Screen s) {
        p.observers.remove(s);
    }
    
    pointcut changes(Point p) : target(p) && call(void Point.set*(int));
    
    after(Point p) : changes(p) {
        Iterator<Screen> iter = p.observers.iterator();
        while (iter.hasNext()) {
            updateObserver(p, iter.next());
        }
        
        System.out.println(p.x);
        System.out.println(p.y);
    }
    
    static void updateObserver(Point p, Screen s) {
        s.display(p);
    }
    
    before(Point p) : changes(p) {
        System.out.println("Entering: " + thisJoinPoint);
        System.out.println("Static part: " + thisJoinPointStaticPart);
        System.out.println("Kind: " + thisJoinPointStaticPart.getKind());
        System.out.println("Signature: " + thisJoinPointStaticPart.getSignature());
        System.out.println("Source location: " + thisJoinPointStaticPart.getSourceLocation());
        System.out.println("Id: " + thisJoinPointStaticPart.getId());
        System.out.println("Enclosing: " + thisEnclosingJoinPointStaticPart);
    }
}
