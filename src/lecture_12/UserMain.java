package lecture_12;

import java.io.*;

public class UserMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("Petya", "man", new Address("Minsk"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/hello.txt"));
        oos.writeObject(user);
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/hello.txt"));
        Object o = ois.readObject();

        if(o instanceof User){
            User user1=(User) o;
            System.out.println(user1);
        }

        ois.close();

    }
}
