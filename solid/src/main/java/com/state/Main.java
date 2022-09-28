package com.state;

public class Main {
    public static void main(String[] args) {

        MathService mathService = new MathService(FUNC.SUM);
        Integer process = mathService.process(10, 20);
        System.out.println(process);
    }
}
