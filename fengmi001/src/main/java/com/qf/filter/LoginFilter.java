package com.qf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1= (HttpServletRequest) request;
        HttpServletResponse response1= (HttpServletResponse) response;
        HttpSession session = request1.getSession(false);

        String requestURI = request1.getRequestURI();
        if (requestURI.endsWith("login.jsp")||requestURI.endsWith("LoginServlet")){
            chain.doFilter(request,response);
        }else if (session==null||session.getAttribute("user")==null){
            response1.sendRedirect("/fengmi001/after/login.jsp");
        }else if (session.getAttribute("user")!=null){
            chain.doFilter(request,response);
        }
    }
}
