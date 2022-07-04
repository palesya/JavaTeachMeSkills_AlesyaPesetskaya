package com.servlets;

import com.exceptions.NoSuchUserException;
import com.objects.User;
import com.objects.UserContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.objects.User.Role.ADMIN;

@WebServlet(value = "/home")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserContainer userContainer = new UserContainer();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        List<User> user = userContainer.returnUser(login, password);
        if (user.size() > 0) {
            List<User.Role> roles = user.stream().map(User::getRole).collect(Collectors.toList());
            if (roles.contains(ADMIN)) {
                resp.sendRedirect("/homework_24/adminPage");
            } else {
                resp.sendRedirect("/homework_24/userPage");
            }
        } else {
            throw new NoSuchUserException("Such User is not created.");
        }
    }
}
