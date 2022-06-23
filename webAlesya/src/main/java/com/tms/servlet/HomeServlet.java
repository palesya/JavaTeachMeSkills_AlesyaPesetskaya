package com.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        Map<String, String[]> parameterMap = req.getParameterMap();
        StringBuilder builder = new StringBuilder();
        parameterMap.forEach((s, strings) -> builder.append(s + " : " + strings[0] + "\n"));

        String myheader = req.getHeader("myheader");

        String app = req.getParameter("app");
        PrintWriter writer = resp.getWriter();
        writer.println("hello from servlet \n" + app + "\n" + builder);
        writer.println(myheader);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("hello from post");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("delete");
        resp.setStatus(204);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("user","homeservlet");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init method");
        super.init();
    }
}
