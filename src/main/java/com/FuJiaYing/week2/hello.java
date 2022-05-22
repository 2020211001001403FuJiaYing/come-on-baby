package com.FuJiaYing.week2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/hello")
public class hello  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response
    )            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name:FuJiaYing");
        writer.println("ID:2020211001001403");
        writer.println("Date and Time Sat Mar 5 14:20:55 CST 2022");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
