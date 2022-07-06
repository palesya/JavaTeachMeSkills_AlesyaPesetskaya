package com.tms.users.service;

import com.tms.users.dao.DBStore;
import com.tms.users.objects.Car;

import java.util.Map;

public class CarService {

    DBStore dbStore = DBStore.getCarContainer();

    public Integer saveCarAndReturnId(Car car) {
        Map<Integer, Car> allCars = dbStore.getAllCars();
        Integer id;
        if (allCars.isEmpty()) {
            id = 1;
        } else {
            id = allCars.size() + 1;
        }
        allCars.put(id, car);
        return id;
    }

    public void deleteCarById(Integer id) {
        Map<Integer, Car> allCars = dbStore.getAllCars();
        allCars.remove(id);
    }

    public void updateCarById(Integer id, Car car) {
        Map<Integer, Car> allCars = dbStore.getAllCars();
        allCars.replace(id,car);
    }

    public Map<Integer, Car> getAllCars() {
        return dbStore.getAllCars();
    }

    public Car getCarById(Integer id) {
        return dbStore.getById(id);
    }

}
