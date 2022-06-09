package lecture_18;

public class BlockService {

    A a;
    B b;

    public BlockService(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public void inc(){
        synchronized (a){
            System.out.println("inc a");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (b){
                System.out.println("inc b");
            }
        }
    }
    public void decr(){
        synchronized (b){
            System.out.println("decr b");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (a){
                System.out.println("decr a");
            }
        }
    }
}
