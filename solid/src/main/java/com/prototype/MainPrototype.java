package com.prototype;

public class MainPrototype {
    public static void main(String[] args) {
        Data data = new Data("Hello");
        Data clone = data.clone();
        System.out.println(clone);
        data.setName("new name");
        System.out.println(clone);
    }
}
