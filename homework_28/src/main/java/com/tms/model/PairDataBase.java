package com.tms.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class PairDataBase {

    private List<Pair> pairs;

    public void setPairs(List<Pair> pairs) {
        this.pairs=pairs;
    }

}
