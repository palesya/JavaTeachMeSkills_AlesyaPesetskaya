package com.servlets;

import com.objects.User;
import com.objects.UserContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminPage")
public class RegisterUserServlet extends HttpServlet {

    UserContainer userContainer;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("adminPage.html").forward(req, resp);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String role = req.getParameter("role");
        User user = new User(login, password, User.Role.valueOf(role), User.Sex.valueOf(sex));
        userContainer.saveUser(user);
        req.getRequestDispatcher("/success").forward(req, resp);
    }
}
