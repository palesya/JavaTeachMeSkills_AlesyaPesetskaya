package com.strategy;

public class SumMathServiceStrategyImpl implements MathServiceStrategy {
    @Override
    public Integer process(Integer v1, Integer v2) {
        return v1+v2;
    }
}
