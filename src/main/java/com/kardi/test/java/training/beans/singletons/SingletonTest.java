package com.kardi.test.java.training.beans.singletons;

/**
 * Created by Kardi on 30.03.2015.
 */
public class SingletonTest {

    private int variable = 1;

    static {
        System.out.println("[SingletonTest] loaded into STATIC context");
    }

    private SingletonTest() {
        System.out.println("[SingletonTest] new INSTANCE created ");
    }

    public String checkPublic() {
        return "checkPublic: " + variable;
    }

    public void setVariable(int v) {
        System.out.println("[SingletonTest] setVariable called from the context loader");
        variable = v;
    }

}
