package Homework_7.Documents.documents;

import Homework_7.Documents.Document;

import java.util.Date;

public class FinancialInvoice extends Document {

    private int monthlyTotal;
    private String departureCode;

    public FinancialInvoice(int number, Date documentDate) {
        super(number, documentDate);
    }

    public FinancialInvoice(int number, Date documentDate, int monthlyTotal, String departureCode) {
        super(number, documentDate);
        this.monthlyTotal = monthlyTotal;
        this.departureCode = departureCode;
    }

    public double getMonthlyTotal() {
        return monthlyTotal;
    }

    public void setMonthlyTotal(int monthlyTotal) {
        this.monthlyTotal = monthlyTotal;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    @Override
    public void printDocInfo() {
        System.out.println("");
        System.out.printf("\nDocument number %d, \ndocument date %s, \ntotal for month %d, \ndeparture code %s", this.number, this.documentDate, this.monthlyTotal, this.departureCode);
    }

    @Override
    public String toString() {
        return "FinancialInvoice" +
                "\nnumber of document: " + number +
                "\ndocument's date: " + documentDate +
                "\nmonthly total = " + monthlyTotal +
                "\ncode of departure is'" + departureCode + '\'';


    }

}
