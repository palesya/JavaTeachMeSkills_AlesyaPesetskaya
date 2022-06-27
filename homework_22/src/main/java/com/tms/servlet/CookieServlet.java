package com.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter writer = resp.getWriter();
        if (cookies != null) {
            List<Cookie> date = Arrays.stream(cookies).filter(cookie ->
                    cookie.getName().equals("date")).collect(Collectors.toList());
           writer.println(date);
        } else {
            writer.println("No cookies found");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate date = LocalDate.from(LocalDate.now());
        Cookie currentDate = new Cookie("date", date.toString());
        Cookie userName = new Cookie("user_name", "Alesya");
        resp.addCookie(currentDate);
        resp.addCookie(userName);
    }
}
