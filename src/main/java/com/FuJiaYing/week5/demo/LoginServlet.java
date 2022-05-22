package com.FuJiaYing.week5.demo;

import com.FuJiaYing.DAO.IUserDao;
import com.FuJiaYing.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
        public void init() throws ServletException{
        super.init();
        ///TODO 1: GET 4 CONTEXT PARAM - DRIVER , URL , USERNAME , PASSWORD
        //TODO 2: GET JDBC connection
        con = (Connection)getServletContext().getAttribute( "con");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO 3：GRT REQUESST PARAMETER - USERNAME AND PASSWORD

        String username=request.getParameter( "username");
        String password=request.getParameter( "password");

        UserDao userDao=new UserDao();
        try{
            User user=UserDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null&&rememberMe.equals("1")){
                    String name;
                    Cookie usernameCookie=new Cookie(  name: "cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie(  name: "cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie( name: "cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);

                }
               HttpSession session=request.getSession();
               System.out.println("session id-->"+session.getId());
               session.setMaxInactiveInterval(10);



                session.setAttribute( "user",user);
                request.getRequestDispatcher( "WEB-INF/view/userInfo.jsp").forward(request,response);
            }else{

            }

        catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        //TODO 4: VALIDATE USER - SELEECT * FROM USERTABLE WHERE USERNAME='FuJiaYing'
        // and password='123456'
        String sql="select username,password from usertable where username='"+username+"' and password="123456"'
            try{
                ResultSet rs =con.createStatement().executeQuery(sql);
                if(rs.next()) {
                    //out.print("Login Successful!!!");
                    //out.print("Welcome"+username);
                    request.setAttribute("id",rs.getInt(columnLable:"id"));
                    request.setAttribute("username",rs.getInt(columnLable:"username"));
                    request.setAttribute("passage",rs.getInt(columnLable:"passage"));
                    request.setAttribute("email",rs.getInt(columnLable:"email"));
                    request.setAttribute("gender",rs.getInt(columnLable:"gender"));
                    request.setAttribute("birthDate",rs.getInt(columnLable:"birthDate"));
                    //forward to user info jsp
                    request.getRequestDispatcher("userList.jsp").forward(request,response);
                }else{
                    //out.print("Username or password Error!!!");
                    request.setAttribute( "massage",  "Username or password Error!!!");
                    request.getRequestDispatcher(  "WEB-INF/view/login.jsp").forward(request,response);
                }//end of else
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }

        // TODO 5: CHEK IF(USER IS VALID){
        //  OUT.PRINTLN("login successful !!!");
        // OUT.PRINT ("welcome,username");
        //}ELSE{
        //  OUT.PRINT(LOGIN ERROR!!!);
         //}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher( "WEB-INF/views/login.jsp").forward(request,response);

    }
}
