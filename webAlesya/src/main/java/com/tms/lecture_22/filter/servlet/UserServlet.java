package com.tms.lecture_22.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doProcess(req,resp);
    }

    void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        resp.getWriter().println("Hello, " + login + "\nwith password " + password + "\nand age " + age);
        try {
            Part pic = req.getPart("pic");
            InputStream inputStream = pic.getInputStream();
            int available = inputStream.available();
            byte[] bytes = new byte[available];
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


}
