package com.strategy;

public class Main {
    public static void main(String[] args) {

        MathServiceStrategy sum = new SumMathServiceStrategyImpl();
        MathServiceStrategy mul = new MulMathServiceStrategyImpl();
        System.out.println(sum.process(10, 20));
        System.out.println(mul.process(10, 20));
    }

}
