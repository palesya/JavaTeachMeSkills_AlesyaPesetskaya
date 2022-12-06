package Patterns.Behavioral.ChainOfResponsibility;

public class EmailNotifierImpl extends Notifier {

    @Override
    public void setNextNotifier() {
        this.nextNotifier = new CallNotifierImpl();
    }

    @Override
    public void setStatus() {
        this.status = STATUS.IMPORTANT;
    }

    @Override
    public void write(String message) {
        System.out.println("Notifying via email " + message);
    }
}
