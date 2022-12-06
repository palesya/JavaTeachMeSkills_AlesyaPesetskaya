package Patterns.Behavioral.ChainOfResponsibility;

public class CallNotifierImpl extends Notifier {

    @Override
    public void setNextNotifier() {
        this.nextNotifier = null;
    }

    @Override
    public void setStatus() {
        this.status = STATUS.ASAP;
    }

    @Override
    public void write(String message) {
        System.out.println("Calling manager ASAP " + message);
    }
}
