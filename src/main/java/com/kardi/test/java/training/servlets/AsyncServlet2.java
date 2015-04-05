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

@WebServlet(urlPatterns = "/async-servlet-api2", asyncSupported = true)
public class AsyncServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<br>Thread servlet: " + Thread.currentThread().toString() + "<br>");

        final AsyncContext asyncContext = request.startAsync(request, response);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                PrintWriter writer = null;
                try {
                    writer = asyncContext.getResponse().getWriter();
                    writer.println("<br>Thread processor: " + Thread.currentThread().toString() + "<br>");
                    writer.println("<progress id='progress' max='100'></progress>");

                    for (int i = 0; i < 100; i++) {
                        writer.println("<script>document.getElementById('progress').value=\"" + i + "\";</script>");
                        writer.flush();

                        Thread.sleep(100);
                    }
                    writer.println("</body></html>");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                asyncContext.complete();
            }
        });


        //writer.println("<script>document.getElementById('progress').style.display='none';</script>");
    }

}
