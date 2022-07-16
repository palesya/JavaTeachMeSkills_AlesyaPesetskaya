package com.tms.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class PairDataBase {

    Pair pair1;
    Pair pair2;
    Pair pair3;

    private static List<Pair> pairs = new ArrayList<>();

    public PairDataBase(Pair pair1, Pair pair2,Pair pair3) {
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
    }

    public List<Pair> getAllPairs(){
        return pairs;
    }

}
