package com.honnix.jsandbox.aspectj;

public aspect TestAspectJ {
    public int Test.age;

    public void Test.setAge(int age) {
        this.age = age;
    }
    
    private interface HasName {}
    
    declare parents : Test implements HasName;
    
    private String HasName.name;
    
    public void HasName.setName(String name) {
        this.name = name;
    }
    
    public String HasName.getName() {
        return name;
    }

    pointcut fooPC() : execution(void Test.foo());

    pointcut gooPC() : execution(void Test.goo());

    pointcut printPC() : call(void java.io.PrintStream.println(String));

    before() : cflow(fooPC()) && cflow(gooPC()) && printPC() && !within(TestAspectJ) {
        System.out.println("should occur");
    }

    before() : cflow(fooPC() && gooPC()) && printPC() && !within(TestAspectJ) {
        System.out.println("should not occur");
    }
}
