package Patterns.Creational.AbstractFactory.factory;

import Patterns.Creational.AbstractFactory.circle.AudiCircleImpl;
import Patterns.Creational.AbstractFactory.circle.Circle;
import Patterns.Creational.AbstractFactory.engine.AudiEngineImpl;
import Patterns.Creational.AbstractFactory.engine.Engine;

public class AudiFactoryImpl implements CarFactory {


    @Override
    public Engine createEngine() {
        return new AudiEngineImpl();
    }

    @Override
    public Circle createCircle() {
        return new AudiCircleImpl();
    }
}
