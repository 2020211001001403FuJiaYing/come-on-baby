package com.FuJiaYing.controller;

import com.FuJiaYing.DAO.IUserDao;
import com.FuJiaYing.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet",value = "/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        get all (6) request parameters
        todo2: create an object of User Model
        todo3: set all (6) request parameters values intp User model - setXXX()
        todo4: create an object of UserDao
        todo5: Call updateUser() in UserDap
        todo6:forward to WEB-INF/view/UserInfo.jsp
        */
        Integer id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        java.util.Date birthdate = Date.valueOf(request.getParameter("birthDate"));
        User user = new User(id,username,password,email,gender,birthdate);
        User userDao = new UserDao()
        try {
            userDao.updateUser(con, user);
            User byId = userDao.findById(con, user.getId());
            request.getSession().setAttribute("user",byId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("accountDetails").forward(request,response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //todo1: forward to WEB-INF/view/updateUser.jsp
      //todo2: create one jsp page - update User
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
}
