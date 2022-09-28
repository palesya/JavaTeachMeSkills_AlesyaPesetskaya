package com.adapter;

public class AdapterFigure3 implements Figure{

    Figure3 figure3;

    public AdapterFigure3(Figure3 figure3) {
        this.figure3 = figure3;
    }

    @Override
    public void print() {
        figure3.printMyInfo();
    }
}
