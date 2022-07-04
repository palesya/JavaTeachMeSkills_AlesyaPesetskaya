package com.tms.servlet;

import objects.Car;
import objects.CarContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/car")
public class CarService extends HttpServlet {

    CarContainer container = new CarContainer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Map<Integer, Car> cars = container.getCars();
        if (!container.findIdInRequest(req, resp)) {
            writer.println("The list of all cars is:");
            cars.forEach((key, value) -> writer.println(key + " : " + value));
        } else {
            int id = container.returnIdIfFound(req, resp);
            if (id >= 0) {
                writer.println("was found \n" + cars.get(id));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        container.saveCar(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Map<Integer, Car> cars = container.getCars();
        if (container.findIdInRequest(req, resp)) {
            int id = container.returnIdIfFound(req, resp);
            if (id >= 0) {
                cars.replace(id, container.createCar(req));
                writer.println("was updated");
            }
        }
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Map<Integer, Car> cars = container.getCars();
        if (container.findIdInRequest(req, resp)) {
            int id = container.returnIdIfFound(req, resp);
            if (id >= 0) {
                cars.remove(id);
                writer.println("was removed");
            }
        }
    }

}
