package Homework_7.Documents;

import java.util.Date;

public abstract class Document {
    int number;
    Date documentDate;

    public Document(int number, Date documentDate) {
        this.number = number;
        this.documentDate = documentDate;
    }

}
