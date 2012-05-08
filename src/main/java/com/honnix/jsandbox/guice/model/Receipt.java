package com.honnix.jsandbox.guice.model;

/**
 * @author honnix
 */
public class Receipt {
    public static Receipt forSuccessfulCharge(int amount) {
        return null;
    }

    public static Receipt forDeclinedCharge(String declineMessage) {
        return null;
    }

    public static Receipt forSystemFailure(String message) {
        return null;
    }
}
