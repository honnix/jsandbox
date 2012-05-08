package com.honnix.jsandbox.guice.model;

/**
 * @author honnix
 */
public interface ChargeResult {
    boolean wasSuccessful();

    String getDeclineMessage();
}
