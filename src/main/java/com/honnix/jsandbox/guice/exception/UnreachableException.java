package com.honnix.jsandbox.guice.exception;

/**
 * @author honnix
 */
public class UnreachableException extends Exception {
    private static final long serialVersionUID = 2438482530720442293L;

    public UnreachableException() {
        super();
    }

    public UnreachableException(String message) {
        super(message);
    }

    public UnreachableException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnreachableException(Throwable cause) {
        super(cause);
    }
}
