package Patterns.Structural.Proxy;

public class Main {

    public static void main(String[] args) {

        DoorImpl simpleDoor = new DoorImpl();
        SecuredDoor securedDoor = new SecuredDoor(simpleDoor);
        securedDoor.open("Open1");
        securedDoor.close();

    }
}
