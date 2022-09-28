package com.strategy;

public class MulMathServiceStrategyImpl implements MathServiceStrategy {
    @Override
    public Integer process(Integer v1, Integer v2) {
        return v1*v2;
    }
}
