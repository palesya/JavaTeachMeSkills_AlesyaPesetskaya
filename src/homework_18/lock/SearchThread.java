package homework_18.lock;

public class SearchThread extends Thread{

    boolean isRun = true;
    Container container;
    Object object;

    public SearchThread(Container container, Object object) {
        this.container = container;
        this.object = object;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    @Override
    public void run() {
       while (isRun){
           container.findObject(object);
       }
    }
}
