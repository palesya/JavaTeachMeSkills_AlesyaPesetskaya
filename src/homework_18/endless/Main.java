package homework_18.endless;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Container container = new Container(new ArrayList<>());
        Object object = new Object();

        AddRemoveThread addRemoveThread1 = new AddRemoveThread(container,object);
        AddRemoveThread addRemoveThread2 = new AddRemoveThread(container,object);
        AddRemoveThread addRemoveThread3 = new AddRemoveThread(container,object);

        addRemoveThread1.start();
        addRemoveThread2.start();
        addRemoveThread3.start();

        SearchThread searchThread1 = new SearchThread(container,object);
        SearchThread searchThread2 = new SearchThread(container,object);
        SearchThread searchThread3 = new SearchThread(container,object);

        searchThread1.start();
        searchThread2.start();
        searchThread3.start();
    }
}
