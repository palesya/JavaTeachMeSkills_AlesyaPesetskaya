package homework_12.task_1;

import java.io.*;

import static homework_12.task_1.Sex.MAN;

public class SerializeDesirealize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User user = new User("Ivan", MAN, 32);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/homework_12/User.txt"));
        oos.writeObject(user);
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/homework_12/User.txt"));
        Object o = ois.readObject();

        if (o instanceof User) {
            User user1 = (User) o;
            System.out.println(user1);
        }
        ois.close();
    }
}
