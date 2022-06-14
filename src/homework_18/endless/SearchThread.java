package homework_18.endless;

public class SearchThread extends Thread{

    boolean isRun = true;
    Container container;
    Object object;

    public SearchThread(Container container, Object object) {
        this.container = container;
        this.object = object;
    }

    @Override
    public void run() {
       while (isRun){
           container.findObject(object);
       }
    }
}
