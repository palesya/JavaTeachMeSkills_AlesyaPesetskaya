package com.tms.lecture_26.servlet;

import com.tms.UserDBStore;
import com.tms.lecture_26.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/check")
public class checkServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("oops");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDBStore dbStore = new UserDBStore();
        User byLogin = dbStore.getByLogin(login);
        if (dbStore == null) {
            dbStore.save(new User(login, password));
        } else {
            if (StringUtils.isBlank(password) || !password.equals(byLogin.getPassword())) {
                if (StringUtils.isBlank(password)) {
                    req.setAttribute("message", "Password must be filled");
                }else{
                    req.setAttribute("message", "Password is not correct");
                }
                req.getRequestDispatcher("error/jsp").forward(req, resp);
            }
        }

        req.getRequestDispatcher("users/jsp").forward(req, resp);
    }


}