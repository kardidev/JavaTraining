package com.kardi.test.java.training.special.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by m.lysenchuk on 4/15/15.
 */

@Controller
@RequestMapping("/validation")
public class ValidationController {

    @RequestMapping(value= "/go1", method = RequestMethod.GET)
     public @ResponseBody String validateTestBean() {

        StringBuilder sb = new StringBuilder("<html><body>");

        BeanToTest bean = new BeanToTest();
        bean.name = "aaa";
        bean.email = "incorrect email@fffff.fff";

        validate(bean, sb);
        sb.append("</body></html>");
        return sb.toString();
    }

    @RequestMapping(value= "/go2", method = RequestMethod.GET)
    public @ResponseBody String validateTestBean2() {

        StringBuilder sb = new StringBuilder("<html><body>");

        BeanToTest bean = new BeanToTest();
        bean.name = "1234567891011!";
        bean.email = "incorrectemail@fffff";

        validate(bean, sb);
        sb.append("</body></html>");
        return sb.toString();
    }

    @RequestMapping(value= "/go3", method = RequestMethod.GET)
    public @ResponseBody String validateTestBean3() {

        StringBuilder sb = new StringBuilder("<html><body>");

        BeanToTest bean = new BeanToTest();
        bean.name = "NameOK";
        bean.email = "mail@ok.com";

        validate(bean, sb);
        sb.append("</body></html>");
        return sb.toString();
    }

    private void validate(BeanToTest bean, StringBuilder sb) {
        sb.append("bean: " + bean.toString() + "<br>");
        sb.append("Validation errors:<br>");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<BeanToTest>> violations = validator.validate(bean);

        for (ConstraintViolation<BeanToTest> violation : violations) {
            sb.append("<br>" + violation.toString());
        }
    }


}
