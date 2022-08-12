package com.tms.hibernate.repository;

import com.tms.hibernate.model.Car;

import java.util.List;

public interface CarRepository {

    void save (Car car);
    void remove (Integer id);
    void changeAvailability(Integer id);
    List<Car> getAllCars();
    List<Integer> getAllIds();
}
