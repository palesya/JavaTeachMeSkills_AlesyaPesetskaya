package com.tms.filters;

import com.tms.exceptions.AccessFilterException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@WebFilter(value = "/car")
public class FilterForHeaders implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        List<String> headerNames = new ArrayList<>(Collections
                .list(httpRequest.getHeaderNames()));
        String method = httpRequest.getMethod();
        if ("GET".equalsIgnoreCase(method) || headerNames.contains("name")) {
            chain.doFilter(request, response);
        } else {
            throw new AccessFilterException();
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
    }
}
