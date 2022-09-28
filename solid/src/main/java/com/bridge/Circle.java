package com.bridge;

public class Circle implements ColorService{

    Color color;

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
