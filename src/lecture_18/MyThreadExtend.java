package lecture_18;

public class MyThreadExtend extends Thread {

    volatile boolean isRun = true;
    private String name;
    private Value value;

    public MyThreadExtend(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    @Override
    public void run() {

        System.out.println(name);

        for (int i = 0; i < 1000000; i++) {
            synchronized (value){
                value.value += 1;
            }
        }

    }
}
