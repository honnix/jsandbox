package com.honnix.jsandbox.guice.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.LONG;
import static java.util.Locale.ENGLISH;

/**
 * @author honnix
 */
public class WeekendBlocker implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Calendar today = new GregorianCalendar();
        if (today.getDisplayName(DAY_OF_WEEK, LONG, ENGLISH).startsWith("S")) {
            throw new IllegalStateException(
                    methodInvocation.getMethod().getName() + " not allowed on weekends!");
        }
        return methodInvocation.proceed();
    }
}
