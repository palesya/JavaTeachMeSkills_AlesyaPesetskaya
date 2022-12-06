package Patterns.Behavioral.ChainOfResponsibility;

public abstract class Notifier {

    protected STATUS status;
    protected Notifier nextNotifier;

    public Notifier() {
        setStatus();
        setNextNotifier();
    }

    protected abstract void setNextNotifier();

    protected abstract void setStatus();

    public void notifyManager(String message, STATUS level) {
        if (level.priority <= status.priority) {
            write(message);
        }else if (nextNotifier!=null){
            nextNotifier.notifyManager(message,level);
        }
    }

    protected abstract void write(String message);
}
