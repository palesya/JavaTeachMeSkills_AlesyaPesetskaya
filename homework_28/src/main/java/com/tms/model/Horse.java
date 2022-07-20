package com.tms.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Horse {

    String name;
    int speed;

    public Horse(String name) {
        this.name = name;
        this.speed= (int) (50+(Math.random()*50));
    }

}
