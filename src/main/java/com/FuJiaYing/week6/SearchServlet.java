package com.FuJiaYing.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.sun.tools.doclint.Entity.and;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get parameter -<input type="text" name="txt" size=30/> and
            // get parameter -<select name="search"
           //check is txt null
          //redirect to home page --index.jsp
          //}else{
              //if(search ==baidu){
               //redirect to baidu
              //response.sendRedirect("https://www.baidu.com/s?wd="+txt");
        //}else{
             //if(search ==bing){
             //response.sendRedirect("https://www.bing.com/search?q="+txt");
             //else if(search ==google))
                   //response.sendRedirect("https://www.google.com/search?q="+txt);
        //}
        //}
    }//end doGet
}//end class
