package com.kardi.test.java.training.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by m.lysenchuk on 4/2/15.
 */

@WebServlet(urlPatterns = "/async-servlet-api", asyncSupported = false)
public class AsyncServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("async.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println("request response OK");
        } finally {
            if (writer != null) writer.close();
        }


    }

}
