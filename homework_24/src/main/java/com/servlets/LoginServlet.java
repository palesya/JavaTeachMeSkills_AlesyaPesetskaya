package com.servlets;

import com.exceptions.NoSuchUserException;
import com.objects.User;
import com.objects.UserContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.objects.User.Role.ADMIN;
import static com.objects.User.Role.USER;
import static com.objects.User.Sex.MAN;
import static com.objects.User.Sex.WOMAN;

@WebServlet(value = "/home")
public class LoginServlet extends HttpServlet {

    UserContainer userContainer=new UserContainer(Arrays.asList(
            new User("Alesya", "pass", ADMIN, WOMAN),
            new User("Pavel", "pass1", USER, MAN)
    ));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userContainer.checkIfLoginAndPasswordExists(login, password)) {
            List<User.Role> roles = userContainer.getRoleFromLoginPage(login, password);
            RequestDispatcher rd;
            if(roles.contains(ADMIN)){
                rd = req.getRequestDispatcher("/adminPage");
            }else{
                rd = req.getRequestDispatcher("/userPage");
            }
            rd.forward(req,resp);
        } else {
            throw new NoSuchUserException("Such User is not created.");
        }
    }
}
