package lecture_18;

public class MyThreadForPrint extends Thread{

    private DifPrint difPrint;

    public MyThreadForPrint(DifPrint difPrint) {
        this.difPrint = difPrint;
    }

}
