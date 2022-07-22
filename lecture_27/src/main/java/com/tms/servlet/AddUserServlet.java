package com.tms.servlet;

import com.tms.UserDBStore;
import com.tms.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class AddUserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String salary = req.getParameter("salary");

        User user = new User(name,"man".equals(sex)? User.Sex.MAN: User.Sex.WOMAN,Integer.parseInt(salary));
        UserDBStore dbStore = UserDBStore.getInstance();
        dbStore.addUser(user);
        resp.sendRedirect("http://localhost:8080/lecture_27-1/home");
    }
}
