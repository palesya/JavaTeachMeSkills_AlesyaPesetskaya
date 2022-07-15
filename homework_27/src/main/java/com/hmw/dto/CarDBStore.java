package com.hmw.dto;

import java.util.ArrayList;
import java.util.List;

public class CarDBStore {

    private List<Car> cars = new ArrayList<>();

    private static CarDBStore instance = null;

    private CarDBStore() {

    }

    public static CarDBStore getInstance() {
        if (instance == null) {
            instance = new CarDBStore();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Car.BodyStyle> getAllBodyStyles() {
        return List.of(Car.BodyStyle.values());
    }

}
