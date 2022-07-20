package com.tms.model;

import lombok.Getter;

import java.util.List;


@Getter
public class PairDataBase {

    private List<Pair> pairs;

    public void setPairs(List<Pair> pairs) {
        this.pairs=pairs;
    }

}
