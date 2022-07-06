package com.tms.lecture_22.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/loginPage")
public class MyLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String[] cars = req.getParameterValues("cars");
        String[] play = req.getParameterValues("play");
        String date = req.getParameter("date");

        System.out.println("login: " + login + "password" + password + "age" + age + "\n" +
                Arrays.toString(cars) + "\n" + Arrays.toString(play) + "\n" + date);
    }
}
