package com.abstractFactory;

import com.abstractFactory.factory.CarAbstractFactory;

public class CarService {

    public void doCar(CarAbstractFactory factory){
        factory.getEngineInterface().doProcessEngine();
        factory.getCircleInterface().doProcessCircle();
    }

}
