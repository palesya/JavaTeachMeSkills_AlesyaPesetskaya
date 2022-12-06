package Patterns.Structural.Proxy;

public class SecuredDoor {

    private Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }

    public boolean authenticate(String password){
        return password.equals("Open");
    }

    public void open(String password){
        if(authenticate(password)){
            this.door.open();
        }else {
            System.out.println("Door can't be opened. Password is incorrect.");
        }
    }

    public void close(){
        this.door.close();
    }
}
