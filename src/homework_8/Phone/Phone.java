package homework_8.Phone;

import java.util.Arrays;

public class Phone {
    private int number;
    private String model;
    private int weightInGr;

    public Phone(int number, String model, int weightInGr) {
        this(number, model);
        this.weightInGr = weightInGr;
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void receiveCall(String name){
        System.out.println(name+" is calling!");
    }

    public void receiveCall(String name, int phoneNumber){
        System.out.println(name+" is calling from number "+phoneNumber);
    }

    public void sendMessage(int...phoneNumber){
        System.out.println("Message was sent to numbers:");
        System.out.println(Arrays.toString(phoneNumber));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeightInGr() {
        return weightInGr;
    }

    public void setWeightInGr(int weightInGr) {
        this.weightInGr = weightInGr;
    }

    @Override
    public String toString() {
        return "\nPhone's information:" +
                "\nnumber: " + number +
                "\nmodel: " + model+
                "\nweight in grams = " + weightInGr;
    }
}
