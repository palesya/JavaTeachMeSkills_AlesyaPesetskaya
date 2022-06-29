package com.tms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class ParamFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----param filter-----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getParameter("token");
        if(token!=null&&!token.isEmpty()){
            chain.doFilter(request, response);
        }else {
            throw new RuntimeException("Param token is required");
        }
    }

    @Override
    public void destroy() {
        System.out.println("----destroy filter-----");
    }
}
