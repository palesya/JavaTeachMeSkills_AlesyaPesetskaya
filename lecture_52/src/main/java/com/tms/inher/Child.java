package main.java.com.tms.inher;

public class Child extends Parent implements Interf {

  public void print(){
      doSmth();
  }

  @Override
  public void doSmth(){
      System.out.println("child");
  }

  public void newPrint(){
      super.doSmth();
  }

    @Override
    public void fromInt() {
        System.out.println("from child");
        Interf.super.fromInt();
    }
}
