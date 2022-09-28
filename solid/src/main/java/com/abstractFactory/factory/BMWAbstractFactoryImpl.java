package com.abstractFactory.factory;

import com.abstractFactory.circle.BMWCircleInterfaceImpl;
import com.abstractFactory.circle.CircleInterface;
import com.abstractFactory.engine.BMWEngineInterfaceImpl;
import com.abstractFactory.engine.EngineInterface;

public class BMWAbstractFactoryImpl implements CarAbstractFactory {
    @Override
    public CircleInterface getCircleInterface() {
        return new BMWCircleInterfaceImpl();
    }

    @Override
    public EngineInterface getEngineInterface() {
        return new BMWEngineInterfaceImpl();
    }
}
