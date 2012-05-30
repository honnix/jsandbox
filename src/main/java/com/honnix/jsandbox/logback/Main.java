package com.honnix.jsandbox.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author honnix
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        while (true) {
            LOGGER.info("blablalba\n");
            Thread.sleep(1000);
        }
    }

    private Main() {
        super();
    }
}
