package com.kardi.test.java.training.servlets;

import com.kardi.test.java.training.SpringContext;
import com.kardi.test.java.training.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kardi on 30.03.2015.
 */
public class MyServlet extends HttpServlet {

    private ApplicationContext applicationContext = SpringContext.getApplicationContext();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextConfigLocation = getServletContext ().getInitParameter("contextConfigLocation");
        System.out.println("contextConfigLocation = " + contextConfigLocation);

        if (applicationContext != null) {
            Test test = (Test)applicationContext.getBean("test");
            System.out.println("Test.checkPublic = " + test.checkPublic());
        }

        resp.sendError(400, "jajajaja");

    }
}
