package com.adapter;

public class AdapterMain {
    public static void main(String[] args) {

     AdapterTestService service = new AdapterTestService();
     service.process(new Figure1Impl());
     service.process(new Figure2Impl());
     service.process(new AdapterFigure3(new Figure3()));

    }
}
