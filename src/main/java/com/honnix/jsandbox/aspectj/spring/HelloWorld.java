package com.honnix.jsandbox.aspectj.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    private void say() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/applicationContext.xml");

        HelloWorld h = new HelloWorld();
        h.say();

        context.getBean(GoodbyeWorld.class).say();
    }

}
