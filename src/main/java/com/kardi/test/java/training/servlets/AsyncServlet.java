package com.kardi.test.java.training.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by m.lysenchuk on 4/2/15.
 */

@WebServlet(urlPatterns = "/async-servlet-api", asyncSupported = true)
public class AsyncServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/async.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final AsyncContext ctx = request.startAsync(request, response);
        ctx.getResponse().setContentType("text/html");

        new Thread() {

            AsyncContext context = ctx;

            @Override
            public void run() {
                try {
                    ServletResponse response = context.getResponse();
                    response.setContentType("text/html");

                    doJob("Part 1 is done. ");
                    doJob("Part 2 is done. ");
                    doJob("The work was DONE. ");
                    context.complete();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            private void doJob(String msg) throws IOException {
                ServletResponse response = context.getResponse();
                try {
                    waitASec();
                    PrintWriter writer = response.getWriter();
                    writer.println(msg);
                    writer.flush();
                } finally {

                }

            }

            private void waitASec() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

}
