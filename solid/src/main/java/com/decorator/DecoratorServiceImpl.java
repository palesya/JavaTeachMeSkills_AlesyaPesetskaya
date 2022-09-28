package com.decorator;

import java.util.Random;

public class DecoratorServiceImpl implements DecoratorService {

    @Override
    public Integer read() {
        return new Random().nextInt();
    }

}
