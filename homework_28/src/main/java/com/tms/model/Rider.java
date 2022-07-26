package com.tms.model;

import lombok.Data;

@Data
public class Rider {

    String name;
    double quality;

    public Rider(String name) {
        this.name = name;
        this.quality= 0.5+(Math.random()/2);
    }
}
