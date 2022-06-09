package homework_18.endless;

import java.util.ArrayList;

import static homework_18.endless.Container.ACTION.ADD_ACTION;
import static homework_18.endless.Container.ACTION.REMOVE_ACTION;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Container container = new Container(new ArrayList<>());
        Object object = new Object();

        while (true) {
            Thread threadModify1 = new Thread(() -> container
                    .saveRemoveObject(object, REMOVE_ACTION));

            Thread threadModify2 = new Thread(() -> container
                    .saveRemoveObject(object, ADD_ACTION));

            Thread threadModify3 = new Thread(() -> container
                    .saveRemoveObject(object, ADD_ACTION));

            Thread threadFind1 = new Thread(() -> container
                    .findObject(object));

            Thread threadFind2 = new Thread(() -> container
                    .findObject(object));

            Thread threadFind3 = new Thread(() -> container
                    .findObject(object));

            threadModify1.start();
            threadModify2.start();
            threadModify3.start();
            threadFind1.start();
            threadFind2.start();
            threadFind3.start();

        }
    }
}
