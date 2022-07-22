package com.hmw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private UUID uuid;
    private String brand;
    private String model;
    private BodyStyle body;
    private long price;

    public enum BodyStyle {
        SEDAN, COUPE, HATCHBACK, CONVERTIBLE, MINIVAN, PICKUP
    }

    public Car(String brand, String model, BodyStyle body, long price) {
        this.brand = brand;
        this.model = model;
        this.body = body;
        this.price = price;
        uuid=UUID.randomUUID();
    }

}
