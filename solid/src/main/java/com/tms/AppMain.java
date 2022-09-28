package com.tms;

import com.tms.model.Operation;
import com.tms.service.MathService;

public class AppMain {
    public static void main(String[] args) {

        MathService mathService = new MathService();
        mathService.process(12,12, Operation.SUM);

        SingletonService.getInstance();
        SingletonService.getInstance();
    }
}
