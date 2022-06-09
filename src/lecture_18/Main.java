package lecture_18;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Value value = new Value();
        Value value1 = new Value();

        MyThreadExtend extend1 = new MyThreadExtend("ext1",value);
        // MyThreadImpl impl = new MyThreadImpl();
        MyThreadExtend extend2 = new MyThreadExtend("ext2",value);
        MyThreadExtend extend3 = new MyThreadExtend("ext2",value1);

        System.out.println("Hello from main");

        extend1.setPriority(10);
        extend2.setPriority(1);

        extend1.start();
        extend2.start();
        extend3.start();

//        Thread implThread = new Thread(impl);
//        implThread.start();

        //Thread.sleep(500);
        extend1.setRun(false);
        extend2.setRun(false);


        System.out.println(extend1.isAlive());

        //extend.join();
        //implThread.join();

        extend1.join();
        extend2.join();
        extend3.join();

        System.out.println(value.value);
        System.out.println(value1.value);
        System.out.println("End main");

    }
}
