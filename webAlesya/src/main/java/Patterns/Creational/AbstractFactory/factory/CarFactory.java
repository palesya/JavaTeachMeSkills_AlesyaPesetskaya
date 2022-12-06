package Patterns.Creational.AbstractFactory.factory;

import Patterns.Creational.AbstractFactory.circle.Circle;
import Patterns.Creational.AbstractFactory.engine.Engine;

public interface CarFactory {

    Engine createEngine();
    Circle createCircle();

}
