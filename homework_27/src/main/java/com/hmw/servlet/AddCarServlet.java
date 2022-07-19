package com.hmw.servlet;


import com.hmw.dto.Car;
import com.hmw.dto.CarDBStore;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String brand = StringUtils.isEmpty(req.getParameter("brand"))? "no brand" : req.getParameter("brand");
        String model = StringUtils.isEmpty(req.getParameter("model")) ? "no model" : req.getParameter("model");
        String body = req.getParameter("body");
        String price = StringUtils.isEmpty(req.getParameter("price")) ? "0" : req.getParameter("price");

        Car car = new Car(brand, model, Car.BodyStyle.valueOf(body), Integer.parseInt(price));
        CarDBStore dbStore = CarDBStore.getInstance();
        dbStore.addCar(car);
        resp.sendRedirect("http://localhost:8080/homework_27/home");
    }
}
