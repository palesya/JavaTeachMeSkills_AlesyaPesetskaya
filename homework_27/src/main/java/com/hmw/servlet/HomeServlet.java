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
    public void init() {
        CarDBStore dbStore = CarDBStore.getInstance();
        dbStore.addCar(new Car("Mazda","MX-5 Miata", Car.BodyStyle.CONVERTIBLE,50000));
        dbStore.addCar(new Car("Ford","Mustang", Car.BodyStyle.CONVERTIBLE,90000));
        dbStore.addCar(new Car("Chevy","Camaro", Car.BodyStyle.CONVERTIBLE,480000));
        dbStore.addCar(new Car("Ford","Maverick", Car.BodyStyle.PICKUP,560000));
        dbStore.addCar(new Car("Hyundai","Santa Cruz", Car.BodyStyle.PICKUP,150000));
        dbStore.addCar(new Car("Hyundai","Accent", Car.BodyStyle.SEDAN,48000));
        dbStore.addCar(new Car("Kia","Rio", Car.BodyStyle.SEDAN,35000));
        dbStore.addCar(new Car("Toyota","GR86", Car.BodyStyle.COUPE,78000));
    }


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
