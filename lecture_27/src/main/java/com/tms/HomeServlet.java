package com.tms;

import com.tms.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.tms.dto.User.Sex.MAN;
import static com.tms.dto.User.Sex.WOMAN;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        UserDBStore dbStore = UserDBStore.getInstance();
        dbStore.addUser(new User("Pavel", MAN,5000));
        dbStore.addUser(new User("Alesya", WOMAN,3000));
        dbStore.addUser(new User("Svetlana", WOMAN,1200));
        dbStore.addUser(new User("Ivan", MAN,500));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDBStore dbStore = UserDBStore.getInstance();
        List<User> users = dbStore.getAll();
        req.setAttribute("users", users);
        req.setAttribute("message", "Hello there");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_uuid = req.getParameter("username");
        UUID uuid = UUID.fromString(user_uuid);
        UserDBStore dbStore = UserDBStore.getInstance();
        User userFromDB = dbStore.getAll().stream().filter(user -> user.getUuid().equals(uuid)).findFirst().get();
        dbStore.deleteUser(userFromDB);
        resp.sendRedirect("http://localhost:8080/lecture_27-1/home");
    }
}
