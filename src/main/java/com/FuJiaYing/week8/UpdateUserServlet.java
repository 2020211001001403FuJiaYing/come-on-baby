package com.FuJiaYing.week8;



import com.FuJiaYing.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User usr = new User();
        usr.setID(request.getParameter("ID"));
        usr.setName(request.getParameter("username"));
        usr.setPassword(request.getParameter("password"));
        usr.setEmail(request.getParameter("email"));
        usr.setGender(request.getParameter("gender"));
        usr.setBirthdate(request.getParameter("Birthdate"));
        UserDao userDao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("con");
        userDao.updateUser(con, usr);
        request.setAttribute("update", "update");
        request.setAttribute("user", usr);
        request.getRequestDispatcher("WEB-INF/views/usrInfo.jsp").forward(request, response);


    }
}