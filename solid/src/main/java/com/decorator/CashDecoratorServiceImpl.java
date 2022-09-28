package com.decorator;

import java.util.ArrayList;
import java.util.List;

public class CashDecoratorServiceImpl implements DecoratorService {

    private DecoratorService decoratorService;
    List<Integer> list = new ArrayList<>();

    public CashDecoratorServiceImpl(DecoratorService decoratorService) {
        this.decoratorService = decoratorService;
    }

    @Override
    public Integer read() {
        if (list.isEmpty()) {
            for (int i=0; i < 10; i++) {
                list.add(decoratorService.read());
            }
        }
        return list.remove(0);
    }

}
