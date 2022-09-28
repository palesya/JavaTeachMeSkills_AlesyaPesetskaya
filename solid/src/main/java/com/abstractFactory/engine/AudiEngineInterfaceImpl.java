package com.abstractFactory.engine;

public class AudiEngineInterfaceImpl implements EngineInterface {
    @Override
    public void doProcessEngine() {
        System.out.println("Engine for Audi");
    }
}
