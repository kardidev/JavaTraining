package com.kardi.test.java.training.servlets;

import com.kardi.test.java.training.SpringContext;
import com.kardi.test.java.training.beans.singletons.SingletonTest;

import org.springframework.context.ApplicationContext;

import javax.servlet.RequestDispatcher;
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

    /*
     Single instance of servlet can be used by an application server in different threads,
     therefore it's very important to synchronize all the resources outside the "service" method.
     But there is one exception: application server can be set up for single servlet instance
     usage per every thread. Such behaviour is very rare, because it consumes too many resources.
     */


    @Override
    public void init() {
        System.out.println("[MyServlet] init");
    }

    @Override
    public void destroy() {
        System.out.println("[MyServlet] destroy");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[MyServlet] doGet");

        String contextConfigLocation = getServletContext ().getInitParameter("contextConfigLocation");
        System.out.println("contextConfigLocation = " + contextConfigLocation);

        if (applicationContext != null) {
            SingletonTest test = (SingletonTest)applicationContext.getBean("singleton-test");
            System.out.println("[SingletonTest] checkPublic = " + test.checkPublic());
        }

        //resp.sendError(400, "jajajaja");

        req.setAttribute("testAttr", "Hello from the MyServlet!");

        /*
            существует еще один способ получить диспетчер запросов через контекст сервлета,
             он позволяет адресовать запросы на другие контексты других аппликейшенов в пределах сервера


            there is another way to obtain the request dispatcher - using Servlet Context. It allows
            to address any request to other applications in scope of current application server.
            getServletContext().getRequestDispatcher();
         */

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/index.jsp");
        rd.forward(req, resp);
    }
}
