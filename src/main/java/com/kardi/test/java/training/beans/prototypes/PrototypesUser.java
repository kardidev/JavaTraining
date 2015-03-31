package com.kardi.test.java.training.beans.prototypes;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by m.lysenchuk on 3/31/15.
 */
public class PrototypesUser {

    private WorkingPrototype workingPrototype;

    private PrototypesUser(WorkingPrototype workingPrototype) {
        this.workingPrototype = workingPrototype;
    }
}
