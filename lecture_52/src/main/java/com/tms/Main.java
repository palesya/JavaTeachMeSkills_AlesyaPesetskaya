package main.java.com.tms;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread thread = new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("new thread: " + name);
        });
//        thread.start();
//        String name = Thread.currentThread().getName();
//        System.out.println(name);


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(thread);
        future.get();
        System.out.println(future.isDone());
        executorService.shutdown();

        Exchanger<String> exchanger = new Exchanger<>();
        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("start call1");
                String resultFromCall1 = "call1 result";
                Thread.sleep(2000);
                System.out.println("call1 wait");
                String resultFromCall2 = exchanger.exchange(resultFromCall1);
                System.out.println("call 1 got result from call2 "+resultFromCall2);
                return resultFromCall2;
            }
        };

        Callable<String> callable2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("start call2");
                String resultFromCall2 = "call2 result";
                Thread.sleep(10000);
                System.out.println("call2 wait");
                String resultFromCall1 = exchanger.exchange(resultFromCall2);
                System.out.println("call 2 got result from call1 "+resultFromCall1);
                return resultFromCall1;
            }
        };

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(callable1);
        executorService1.submit(callable2);
        executorService1.shutdown();
    }
}
