package Homework_6.Computer_Task;

public class Computer {
    private int price;
    private String model;
    private RAM ram;
    private HDD hdd;

    public Computer(int price, String model, RAM ram, HDD hdd) {
        this.price = price;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
    }

    public Computer(int price, String model) {
        this.price = price;
        this.model = model;
        this.ram = new RAM();
        this.hdd = new HDD();
    }

    @Override
    public String toString() {
        return "\nInfo:"+
                "\ncomputer with " +
                "\nprice = " + price +
                "\nmodel is '" + model + '\'' +
                "\nRAM" + ram +
                "\nHDD" + hdd;
    }
}
