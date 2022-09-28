package com.bridge;

public class BridgeMain {
    public static void main(String[] args) {

        Color red = new RedColorImpl();
        Color white = new WhiteColorImpl();
        Box redBox = new Box(red);
        Circle whiteCircle = new Circle(white);

    }

}
