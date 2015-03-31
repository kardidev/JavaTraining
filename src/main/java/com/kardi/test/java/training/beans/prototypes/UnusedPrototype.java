package com.kardi.test.java.training.beans.prototypes;

/**
 * Created by m.lysenchuk on 3/31/15.
 */
public class UnusedPrototype {

    static {
        System.out.println("[UnusedPrototype] loaded into STATIC context");
    }

    private UnusedPrototype() {
        System.out.println("[UnusedPrototype] new INSTANCE created ");
    }

}
