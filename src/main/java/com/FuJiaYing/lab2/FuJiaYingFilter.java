package com.FuJiaYing.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class FuJiaYingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FuJiaYingFilter-->before chain");
        chain.doFilter(req, resp);
        System.out.println("FuJiaYingFilter-->after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public static class login {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    @WebFilter("/*")
    static//all request
    class FrontEndAuthenticationFilter implements Filter {
        private HttpServletRequest httpRequest=null;
        public static final String[] loginRequiredURLs={"/updateUser","/logout","/cart",
                "/accountDetails","/order"};//url which need login
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {

            httpRequest = (HttpServletRequest)request;//change ServletRequest to HttpServletRequest
            //get path
            String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
            if (path.startsWith("/admin/")){
                Chain.doFilter(request,response);//go to next filter -AdminAuthenticationFilter
                return;
            }

            //get session
            HttpSession session = httpRequest.getSession(false);
            boolean isLoggedIn = (session!=null && session.getAttribute("user")!=null);
            String loginURI = httpRequest.getContextPath()+"/login";//for public user  - not admin
            boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
            boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");

            if (isLoggedIn && (isLoginRequest || isLoginPage)){
                //the admin is already login ande he is trying login again
                //then forward to the public user homepage
                //update 2 ServletRequest and ServletResponse
                httpRequest.getRequestDispatcher("/").forward(request,response);//go to home -public user
                //update 3 i miss !-not
            }else if (!isLoggedIn && isLoginRequired()){//check in loginRequiredURLs array
                //if your is not login in and the requested page requires login
                //then forward to the login page
                //update- 4- use
                request.getRequestDispatcher("/login").forward(request,response);
            }else {
                //for other page which not requires login
                Chain.doFilter(request,response);//go to page
            }

        }
        /*
        method for check requested url need login
         */
        private boolean isLoginRequired() {
            //update 1 url not uri
            String requestURI = httpRequest.getRequestURI().toString();//get url

            for (String loginRequiredURL : loginRequiredURLs){//get one by one from array
                //check
                if (requestURI.contains(loginRequiredURL)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public void destroy() {

        }

        @WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/welcome.jsp"})
        public static class LoginFilter implements Filter {
            public void destroy() {
                System.out.println("i am in LoginFilter--destroy()");
            }

            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
                System.out.println("i am in LoginFilter--doFilter()--request before chain");
                HttpServletRequest req = (HttpServletRequest) request;
                HttpServletResponse res = (HttpServletResponse) response;
                if(req.getSession()!=null&&req.getSession().isNew()){
                    req.getRequestDispatcher("/lab2/welcome.jsp").forward(req,res);
                }else {
                    res.sendRedirect(req.getContextPath()+"/lab2/login.jsp");
                }
                chain.doFilter(request, response);
                System.out.println("i am in LoginFilter--doFilter()--response after chain");
            }

            public void init(FilterConfig config) throws ServletException {
                System.out.println("i am in LoginFilter--init()");
            }

        }
    }
}