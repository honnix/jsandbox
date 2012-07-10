package com.honnix.jsandbox.aspectj;

import java.io.PrintStream;

public aspect HelloFromAspectJ {
    PrintStream logStream = System.err;

    pointcut mainMethod() : execution(public static void main(String[]));

    after() returning : mainMethod() {
        System.out.println("Hello from AspectJ");
        logStream.println("i'm done");
    }
}
