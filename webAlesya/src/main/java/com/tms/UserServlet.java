package com.tms;

import com.tms.lecture_26.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

@WebServlet(value = "/webAlesya/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User alesya = new User("Alesya","123");
        User ivan= new User("Ivan","333");
        PrintWriter writer = resp.getWriter();
        writer.println("<body><H1>");
        Stream.of(alesya,ivan).forEach(user-> writer.println("name"));
    }
}
