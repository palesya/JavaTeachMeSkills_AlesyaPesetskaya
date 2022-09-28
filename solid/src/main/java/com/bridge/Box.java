package com.bridge;

public class Box implements ColorService{

    private Color color;

    public Box(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
