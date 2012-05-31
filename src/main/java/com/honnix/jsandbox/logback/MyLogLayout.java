package com.honnix.jsandbox.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.LayoutBase;

/**
 * @author honnix
 */
public class MyLogLayout extends LayoutBase<ILoggingEvent> {
    public MyLogLayout() {
        super();

        setFileHeader("---- this is my file header ----");
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        return event.getMessage().toString();
    }
}
