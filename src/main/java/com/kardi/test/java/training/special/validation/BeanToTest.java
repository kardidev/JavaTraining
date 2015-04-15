package com.kardi.test.java.training.special.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by m.lysenchuk on 4/15/15.
 */
public class BeanToTest {

    @NotNull(message = "Name must be present!")
    @Size(min = 3, max = 10, message = "The name size must be bigger than 2 and less than 11")
    public String name;

    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
            "+(?:[a-zA-Z]){2,}\\.?)$",
            message = "Email is incorrect")
    public String email;

    public String toString() {
        return String.format("Name: %s | Email: %s", name, email);
    }
}
