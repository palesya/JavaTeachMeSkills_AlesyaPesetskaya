package com.abstractFactory;

import com.abstractFactory.factory.BMWAbstractFactoryImpl;

public class MainCar {

    public static void main(String[] args) {
        CarService carService = new CarService();
        carService.doCar(new BMWAbstractFactoryImpl());
    }

}
