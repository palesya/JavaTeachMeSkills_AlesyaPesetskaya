package Homework_6.Computer_Task;

public class ComputerOutput {
    public static void main(String[] args) {
        Computer computer1=new Computer(3000,"iMac (24-inch, 2021)");
        System.out.println("Computer1 is a "+computer1);
        RAM ram=new RAM("DDR4",16);
        HDD hdd = new HDD("SATA",50, HDD.Type.INTERNAL);
        Computer computer2=new Computer(2000,"Dell XPS Desktop Special Edition",ram,hdd);
        System.out.println("Computer2 is a "+computer2);
    }
}
