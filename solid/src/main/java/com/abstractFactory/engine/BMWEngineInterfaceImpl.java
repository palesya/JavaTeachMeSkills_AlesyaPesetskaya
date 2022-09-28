package com.abstractFactory.engine;

public class BMWEngineInterfaceImpl implements EngineInterface {
    @Override
    public void doProcessEngine() {
        System.out.println("Engine for BMW");
    }
}
