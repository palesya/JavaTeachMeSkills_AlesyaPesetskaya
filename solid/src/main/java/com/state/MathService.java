package com.state;

import static com.state.FUNC.MUL;
import static com.state.FUNC.SUM;

public class MathService {

    FUNC func;

    public MathService(FUNC func) {
        this.func = func;
    }

    public Integer process(Integer v1, Integer v2) {
        if (func == SUM) {
            return sum(v1, v2);
        } else if (func == MUL) {
            return mul(v1, v2);
        } else {
            throw new RuntimeException("not supported");
        }
    }

    private Integer sum(Integer v1, Integer v2) {
        return v1 + v2;
    }

    private Integer mul(Integer v1, Integer v2) {
        return v1 * v2;
    }
}
