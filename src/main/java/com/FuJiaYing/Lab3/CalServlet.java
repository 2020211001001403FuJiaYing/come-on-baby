package com.FuJiaYing.Lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calServlet")
public class CalServlet extends HttpServlet {
    private int add(int firstVal, int secondVal) {
        return firstVal + secondVal;
    }
    private int subtract(int firstVal, int secondVal) {
        return firstVal - secondVal;
    }
    private int multiply(int firstVal, int secondVal) {
        return firstVal * secondVal;
    }
    private double divide(int firstVal, int secondVal) {
        return firstVal / secondVal;
    }
    private int compute (String name) {
        return name.length();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstVal = request.getParameter("first")==null?0:Integer.parseInt(request.getParameter("first"));
        int secondVal = request.getParameter("second")==null?0:Integer.parseInt(request.getParameter("second"));
        String name = request.getParameter("name");
        String action = request.getParameter("action");
        int result = 0;
        if (action.equals("add")) {
            result = add(firstVal,secondVal);
        } else if (action.equals("subtract")) {
            result = subtract(firstVal,secondVal);
        } else if (action.equals("multiply")) {
            result = multiply(firstVal,secondVal);
        } else if (action.equals("divide")) {
            result = (int) divide(firstVal,secondVal);
        } else if (action.equals("compute")) {
            result = compute(name);
        }
        if (action.equals("add") || action.equals("subtract") || action.equals("multiply") || action.equals("divide")) {
            Cookie cFirstCookie = new Cookie("cFirstValue",request.getParameter("first"));
            Cookie cSecondCookie = new Cookie("cSecondValue",request.getParameter("second"));
            Cookie cResultCookie = new Cookie("cResult",String.valueOf(result));
            cFirstCookie.setMaxAge(5);
            cSecondCookie.setMaxAge(5);
            cResultCookie.setMaxAge(5);
            response.addCookie(cFirstCookie);
            response.addCookie(cSecondCookie);
            response.addCookie(cResultCookie);
        } else if (action.equals("compute")) {
            Cookie cNameCookie = new Cookie("cNameValue",request.getParameter("name"));
            Cookie cLenCookie = new Cookie("cLenValue",String.valueOf(result));
            cNameCookie.setMaxAge(5);
            cLenCookie.setMaxAge(5);
            response.addCookie(cNameCookie);
            response.addCookie(cLenCookie);
        }
        response.sendRedirect(request.getContextPath()+"/Lab3/cal.jsp");
    }
}