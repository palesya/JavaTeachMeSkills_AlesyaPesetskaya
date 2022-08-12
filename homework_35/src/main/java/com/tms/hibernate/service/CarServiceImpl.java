package com.tms.hibernate.service;

import com.tms.hibernate.model.Car;
import com.tms.hibernate.repository.CarRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepositoryImpl repository;

    @Override
    public List<Car> getAllCars() {
        return repository.getAllCars();
    }

    @Override
    public void changeAvailability(Integer id) {
        repository.changeAvailability(id);
    }

    @Override
    public List<Integer> getAllIds() {
        return repository.getAllIds();
    }
}
