package com.prototype;

public class Data implements Cloneable{

    private String name;

    public Data(String name) {
        this.name = name;
    }

    @Override
    public Data clone() {
        try {
            return (Data) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                '}';
    }
}
