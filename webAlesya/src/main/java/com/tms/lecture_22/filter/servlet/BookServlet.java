package com.tms.lecture_22.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(value = "/book")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String os = req.getParameter("os");

        PrintWriter writer = resp.getWriter();
        String payload = "<html> <body> <h1>Hello : " + os + " </h1> </body> </html>";
        writer.println(payload);

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies)
                    .map(Cookie::getValue)
                    .forEach(System.out::println);
        }
        resp.addCookie(new Cookie("name", "Alesya"));
    }
}
