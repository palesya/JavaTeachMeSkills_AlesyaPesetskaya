package homework_18.endless;

import static homework_18.AbstractContainer.ACTION.ADD_ACTION;
import static homework_18.AbstractContainer.ACTION.REMOVE_ACTION;

public class AddRemoveThread extends Thread{

    volatile boolean isRun = true;
    Container container;
    Object object;

    public void setRun(boolean run) {
        isRun = run;
    }

    public AddRemoveThread(Container container, Object object) {
        this.container = container;
        this.object = object;
    }

    @Override
    public void run() {
       while (isRun){
           container.saveRemoveObject(object, ADD_ACTION);
           container.saveRemoveObject(object, REMOVE_ACTION);
       }
    }
}
