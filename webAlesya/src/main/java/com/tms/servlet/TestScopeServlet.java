package com.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scope")
public class TestScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("attribute = " + req.getAttribute("att"));
        req.setAttribute("att", "valueOfAtt");
        System.out.println("attribute = " + req.getAttribute("att"));
        req.getRequestDispatcher("/scope").forward(req,resp);

//        ServletContext servletContext = req.getServletContext();
//        servletContext.setAttribute("att","hello from servlet context");
//        System.out.println(servletContext.getAttribute("att"));
    }
}
