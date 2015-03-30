package com.kardi.test.java.training;

/**
 * Created by Kardi on 30.03.2015.
 */
public class Test {

    private int variable = 1;

    private Test() { }

    public String checkPublic() {
        return "checkPublic: " + variable;
    }

    public void setVariable(int v) {
        variable = v;
    }

}
