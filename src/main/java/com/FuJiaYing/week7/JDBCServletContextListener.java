package com.FuJiaYing.week7;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String driver = sce.getServletContext().getInitParameter("driver");
        String url = sce.getServletContext().getInitParameter("url");
        String usr = sce.getServletContext().getInitParameter("usr");
        String password = sce.getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, usr, password);
            System.out.println("连接成功");
            sce.getServletContext().setAttribute("con", con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        System.out.println("i am in contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("i am contextDestroyed");

        sce.getServletContext().removeAttribute("con");
    }
}