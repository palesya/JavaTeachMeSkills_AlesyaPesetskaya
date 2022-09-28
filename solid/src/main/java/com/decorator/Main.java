package com.decorator;

public class Main {
    public static void main(String[] args) {

        CashDecoratorServiceImpl cashDecoratorService = new CashDecoratorServiceImpl(new DecoratorServiceImpl());
        System.out.println(cashDecoratorService.read());
        System.out.println(cashDecoratorService.read());
        System.out.println(cashDecoratorService.read());
    }
}
