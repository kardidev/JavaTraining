package com.kardi.test.java.training.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kardi on 05.04.2015.
 */

@WebServlet(urlPatterns = "/sync-servlet-api")
public class SyncServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println("The work was started. ");
            writer.flush();
            waitASec();
            writer.println("Part 1 is done. ");
            writer.flush();
            waitASec();
            writer.println("Part 2 is done. ");
            writer.flush();
            waitASec();
            writer.println("The work was DONE. ");
            writer.flush();
        } finally {
            if (writer != null) writer.close();
        }
    }

    private void waitASec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
