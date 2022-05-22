package com.FuJiaYing.week;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/c")
public class c extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String AccountNumber= request.getParameter("AccountNumber");
        String Password= request.getParameter("Password");
        PrintWriter writer = response.getWriter();
        writer.println("<br>AccountNumber"+AccountNumber);
        writer.println("<br>Password"+Password);
        writer.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    }}