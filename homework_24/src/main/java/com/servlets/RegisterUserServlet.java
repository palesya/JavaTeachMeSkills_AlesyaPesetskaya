package com.servlets;

import com.exceptions.SaveUserException;
import com.objects.User;
import com.objects.UserContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/adminPage")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("adminPage.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserContainer userContainer = new UserContainer();
        String login = req.getParameter("login");
        if (!userContainer.checkIfLoginExists(login)) {
            String password = req.getParameter("password");
            String sex = req.getParameter("sex").toUpperCase();
            String role = req.getParameter("role").toUpperCase();
            User user = new User(login, password, User.Role.valueOf(role), User.Sex.valueOf(sex));
            userContainer.saveUser(user);
            resp.sendRedirect("/homework_24/success");
        } else {
            throw new SaveUserException("Such login already exists.");
        }
    }
}
