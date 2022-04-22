package Homework_7.Documents;

import java.util.Date;

public class FinancialInvoice extends Document {

    private double monthlyTotal;
    private String departureCode;

    public FinancialInvoice(int number, Date documentDate) {
        super(number, documentDate);
    }

    public FinancialInvoice(int number, Date documentDate, double monthlyTotal, String departureCode) {
        super(number, documentDate);
        this.monthlyTotal = monthlyTotal;
        this.departureCode = departureCode;
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
