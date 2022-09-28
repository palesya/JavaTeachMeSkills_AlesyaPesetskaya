package com.abstractFactory.factory;

import com.abstractFactory.circle.CircleInterface;
import com.abstractFactory.engine.EngineInterface;

public interface CarAbstractFactory {

    CircleInterface getCircleInterface();
    EngineInterface getEngineInterface();

}
