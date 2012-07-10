package com.honnix.jsandbox.aspectj;

public class Test extends HelloWorld {
    static void foo() {
        goo();
    }

    static void goo() {
        System.out.println("hi");
    }

    public static void main(String[] args) {
        foo();
        Test test = new Test();
        test.setName("test");
        test.setAge(1);
        
        System.out.println(Test.class.getInterfaces()[0].getName());
    }
}
