package com.tms.users.servlet;

import com.tms.users.objects.Car;
import com.tms.users.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/car")
public class CarServlet extends HttpServlet {

    CarService service = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Map<Integer, Car> allCars = service.getAllCars();
        if (!findIdInRequest(req, resp)) {
            writer.println("The list of all cars is:");
            allCars.forEach((key, value) -> writer.println("key = " + key + "; car: " + value));
        } else {
            int id = returnIdIfFound(allCars, req, resp);
            if (id >= 0) {
                Car carById = service.getCarById(id);
                writer.println("was found \n" + carById);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Car car = createCar(req);
        Integer id = service.saveCarAndReturnId(car);
        resp.getWriter()
                .println("Id is generated automatically.\nCar with id = " + id + " was created: \n" + car);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Map<Integer, Car> allCars = service.getAllCars();
        if (findIdInRequest(req, resp)) {
            int id = returnIdIfFound(allCars, req, resp);
            if (id >= 0) {
                Car car = createCar(req);
                service.updateCarById(id, car);
                writer.println("was updated");
            }
        }
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Map<Integer, Car> allCars = service.getAllCars();
        if (findIdInRequest(req, resp)) {
            int id = returnIdIfFound(allCars, req, resp);
            if (id >= 0) {
                service.deleteCarById(id);
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

    private boolean findIdInRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isFound = true;
        if (req.getParameter("id") == null) {
            resp.getWriter().println("Id is not defined.");
            isFound = false;
        }
        return isFound;
    }

    private int returnIdIfFound(Map<Integer, Car> allCars, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        if (allCars.containsKey(id)) {
            writer.println("Car with id = " + id);
        } else {
            writer.println("Car with id = " + id + "\n was not found");
            id = -1;
        }
        return id;
    }

}
