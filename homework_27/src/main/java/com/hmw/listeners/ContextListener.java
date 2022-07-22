package com.hmw.listeners;


import com.hmw.dto.Car;
import com.hmw.dto.CarDBStore;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("bodyStyles", Car.BodyStyle.values());
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

}
