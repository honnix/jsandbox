package com.honnix.jsandbox.aspectj.figure;

public aspect SetsInRotateCounting {
    int rotateCount = 0;

    int setCount = 0;

    before() : call(void Line.rotate(int)) {
        ++rotateCount;
    }

    before() : call(void Point.set*(int)) && cflow(call(void Line.rotate(int))) {
        ++setCount;
    }
}
