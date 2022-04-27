package Homework_7.Documents;

import java.util.Date;

public abstract class Document {
    protected int number;
    protected Date documentDate;

    public Document(int number, Date documentDate) {
        this.number = number;
        this.documentDate = documentDate;
    }

    public abstract void printDocInfo();

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }
}
