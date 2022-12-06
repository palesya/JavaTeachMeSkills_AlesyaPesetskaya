package Patterns.Creational.AbstractFactory.factory;

import Patterns.Creational.AbstractFactory.circle.Circle;
import Patterns.Creational.AbstractFactory.circle.VolvoCircleImpl;
import Patterns.Creational.AbstractFactory.engine.Engine;
import Patterns.Creational.AbstractFactory.engine.VolvoEngineImpl;

public class VolvoFactoryImpl implements CarFactory {
    @Override
    public Engine createEngine() {
        return new VolvoEngineImpl();
    }

    @Override
    public Circle createCircle() {
        return new VolvoCircleImpl();
    }
}
