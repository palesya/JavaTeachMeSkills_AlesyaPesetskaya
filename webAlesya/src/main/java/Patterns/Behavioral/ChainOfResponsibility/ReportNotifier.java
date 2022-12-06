package Patterns.Behavioral.ChainOfResponsibility;

public class ReportNotifier extends Notifier {

    @Override
    public void setNextNotifier() {
        this.nextNotifier = new EmailNotifierImpl();
    }

    @Override
    public void setStatus() {
        this.status = STATUS.OK;
    }

    @Override
    public void write(String message) {
        System.out.println("Notifying using simple report " + message);
    }
}
