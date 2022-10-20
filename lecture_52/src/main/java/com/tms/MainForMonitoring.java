package main.java.com.tms;

public class MainForMonitoring {
    public static void main(String[] args) {

        Monitoring monitoring1 = () -> System.out.println("hello from1 ");
        Monitoring monitoring2 = () -> System.out.println("hello from 2");

        monitoring1.startMonitoring();
        monitoring2.startMonitoring();

        testAnCl(new Monitoring() {
            @Override
            public void startMonitoring() {
                System.out.println("hello from 3");
            }
        });
    }

    public static void testAnCl (Monitoring monitoring){
        monitoring.startMonitoring();
    }
}
