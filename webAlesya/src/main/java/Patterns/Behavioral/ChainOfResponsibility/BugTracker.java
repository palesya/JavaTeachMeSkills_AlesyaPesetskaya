package Patterns.Behavioral.ChainOfResponsibility;

import static Patterns.Behavioral.ChainOfResponsibility.STATUS.*;

public class BugTracker {
    public static void main(String[] args) {

        Notifier reportNotifier = new ReportNotifier();
        Notifier emailNotifier = new EmailNotifierImpl();

        reportNotifier.notifyManager("Everything is ok", OK);
        reportNotifier.notifyManager("Something wrong!", IMPORTANT);
        reportNotifier.notifyManager("AAAAAAAAAAAAAAAA!", ASAP);
        emailNotifier.notifyManager("Ok", OK);

    }
}
