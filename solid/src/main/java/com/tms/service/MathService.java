package com.tms.service;

import com.tms.model.Operation;

public class MathService {

    public String process(Integer value1, Integer value2, Operation operation) {
        Integer result = null;
        System.out.println("We want to "+operation.name());
        System.out.println("First value "+value1);
        System.out.println("Second value "+value2);
        switch (operation) {
            case SUM:
                result = value1 + value2;
                System.out.println("Sum is = "+result);
                break;
            case MULTIPLY:
                result = value1 * value2;
                break;
            case DIVISION:
                result = value1 / value2;
                break;
        }
        return result+"";
    }
}
