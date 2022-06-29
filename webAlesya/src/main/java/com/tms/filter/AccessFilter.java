package com.tms.filter;

import com.tms.servlet.AccessFilterException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----init filter-----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String user = request.getParameter("user");
        if (user == null) {
            throw new AccessFilterException();
        }
        if (user.startsWith("tms")) {
            System.out.println("is admin");
            chain.doFilter(request, response);
        } else {
            System.out.println("it is not admin");
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String method = httpRequest.getMethod();
            if ("GET".equalsIgnoreCase(method)){
                System.out.println("it is get");
                chain.doFilter(request, response);
            }else{
                System.out.println("user is allowed only get requests.");
            }
        }

    }

    @Override
    public void destroy() {
        System.out.println("----destroy filter-----");
    }
}
