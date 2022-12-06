package Patterns.Behavioral.ChainOfResponsibility;

public enum STATUS {

    OK(1),
    IMPORTANT(2),
    ASAP(3);

    final int priority;

    STATUS(int priority) {
        this.priority = priority;
    }
}
