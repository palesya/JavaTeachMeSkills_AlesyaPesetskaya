package com.tms.hibernate.service;

import com.tms.hibernate.model.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarService {

    List<Car> getAllCars() throws SQLException;
    void changeAvailability(Integer id);
    List<Integer> getAllIds();
}
