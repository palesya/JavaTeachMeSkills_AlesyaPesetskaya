package com.tms.mybank.core.servlet;

import com.tms.mybank.core.entity.User;
import com.tms.mybank.core.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    private UserService service= new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.save(createUser(req));
        resp.getWriter().println("User is saved");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.update(createUser(req));
    }

    private User createUser(HttpServletRequest req){
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        return new User(name, password);
    }

}
