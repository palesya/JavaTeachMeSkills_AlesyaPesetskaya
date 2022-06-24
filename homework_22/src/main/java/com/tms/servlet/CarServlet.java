package com.tms.servlet;

import objects.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class CarServlet extends HttpServlet {

    Map<Integer, Car> cars = new TreeMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        if (!checkIdInRequest(req,resp)) {
            writer.println("The list of all cars is:");
            cars.forEach((key, value) -> writer.println(key + " : " + value));
        } else {
            int id = getIdFromRequest(req,resp);
            if (id>=0) {
                writer.println("was found \n"+cars.get(id));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        if(checkIdInRequest(req,resp)){
            writer.println("Id is generated automatically.");
        }
        int id = cars.size() + 1;
        Car car = createCar(req);
        cars.put(id, car);
        writer.println("car with id = " + id + " was created: \n" + car);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        if (checkIdInRequest(req,resp)) {
            int id = getIdFromRequest(req, resp);
            if (id >= 0) {
                cars.replace(id, createCar(req));
                writer.println("was updated");
            }
        }
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        if (checkIdInRequest(req, resp)) {
            int id = getIdFromRequest(req, resp);
            if (id >= 0) {
                cars.remove(id);
                writer.println("was removed");
            }
        }
    }

    private Car createCar(HttpServletRequest req) {
        String brand = req.getParameter("brand");
        String year = req.getParameter("year");
        String color = req.getParameter("color");
        return new Car(brand, year, color);
    }

    private int getIdFromRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        if (cars.containsKey(id)) {
            writer.println("Car with id = " + id);
        } else {
            writer.println("Car with id = " + id + "\n was not found");
            id = -1;
        }
        return id;
    }

    private boolean checkIdInRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isFound = true;
        if (req.getParameter("id") == null) {
            resp.getWriter().println("Id is not defined.");
            isFound = false;
        }
        return isFound;
    }
}
