package com.hmw.servlet;

import com.hmw.dto.Car;
import com.hmw.dto.CarDBStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDBStore dbStore = CarDBStore.getInstance();
        List<Car> allCars = dbStore.getAllCars();
        req.setAttribute("cars", allCars);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String car_uuid = req.getParameter("carName");
        UUID uuid = UUID.fromString(car_uuid);
        CarDBStore dbStore = CarDBStore.getInstance();
        Car carFromDB = dbStore.getAllCars().stream()
                .filter(car -> car.getUuid().equals(uuid)).findFirst().get();
        dbStore.deleteCar(carFromDB);
        resp.sendRedirect("http://localhost:8080/homework_27/home");
    }

}
