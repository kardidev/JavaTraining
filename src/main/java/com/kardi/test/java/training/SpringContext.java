package com.kardi.test.java.training;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Kardi on 30.03.2015.
 */
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext ctx = null;

    static {
        System.out.println("SpringContext.static");
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        System.out.println("SpringContext.setApplicationContext");
        this.ctx = ctx;
    }


}
