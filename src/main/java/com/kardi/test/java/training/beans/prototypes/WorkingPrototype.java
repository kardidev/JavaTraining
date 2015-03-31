package com.kardi.test.java.training.beans.prototypes;

/**
 * Created by m.lysenchuk on 3/31/15.
 */
public class WorkingPrototype {

    private static volatile int id = 0;

    static {
        System.out.println("[WorkingPrototype] loaded into STATIC context");
    }

    private int localId = 0;

    private WorkingPrototype() {
        localId = ++id;
        System.out.println("[WorkingPrototype] new INSTANCE created: " + localId);
    }

    public int getLocalId() {
        return localId;
    }
}
