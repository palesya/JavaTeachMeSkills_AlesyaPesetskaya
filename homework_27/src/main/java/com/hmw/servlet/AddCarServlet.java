package com.hmw.servlet;


import com.hmw.dto.Car;
import com.hmw.dto.CarDBStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand").isEmpty() ? "no brand": req.getParameter("brand");
        String model = req.getParameter("model").isEmpty() ? "no model": req.getParameter("model");
        String body = req.getParameter("body");
        String price = req.getParameter("price").isEmpty() ? "0": req.getParameter("price");;

        Car car = new Car(brand, model, Car.BodyStyle.valueOf(body), Integer.parseInt(price));
        CarDBStore dbStore = CarDBStore.getInstance();
        dbStore.addCar(car);
        resp.sendRedirect("http://localhost:8080/homework_27/home");
    }
}
