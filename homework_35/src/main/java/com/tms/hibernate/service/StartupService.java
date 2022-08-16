package com.tms.hibernate.service;

import com.tms.hibernate.model.Car;
import com.tms.hibernate.repository.CarRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.tms.hibernate.model.BRAND.*;

@Service
public class StartupService {

    @Autowired
    private CarRepositoryImpl repository;

    @PostConstruct
    public void init() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Car car1 = new Car("1256 GD-7", RENAULT, simpleDateFormat.parse("01-01-2022"), true);
        Car car2 = new Car("2222 NB-6", BMW, simpleDateFormat.parse("01-01-2018"), true);
        Car car3 = new Car("3333 KJ-5", CHEVROLET, simpleDateFormat.parse("12-01-2010"), false);
        Car car4 = new Car("4444 SD-4", FORD, simpleDateFormat.parse("05-15-2011"), true);
        Car car5 = new Car("5555 AA-3", KIA, simpleDateFormat.parse("12-01-1998"), false);
        Car car6 = new Car("6666 VV-2", AUDI, simpleDateFormat.parse("04-06-2014"), true);
        Car car7 = new Car("7777 EE-1", RENAULT, simpleDateFormat.parse("12-01-2015"), true);
        Car car8 = new Car("8888 GG-7", BMW, simpleDateFormat.parse("03-18-2021"), false);
        Car car9 = new Car("9999 HY-5", VOLVO, simpleDateFormat.parse("12-01-2009"), true);
        Car car10 = new Car("1200 JH-5", NISSAN, simpleDateFormat.parse("01-31-2008"), true);
        Car car11 = new Car("0000 JH-5", NISSAN, simpleDateFormat.parse("01-01-2001"), true);
        Car[] cars = {car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11};
        for (Car car : cars) {
            repository.save(car);
        }
        System.out.println(repository.getAllIds());
    }
}
