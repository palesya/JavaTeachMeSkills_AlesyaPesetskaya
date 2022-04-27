package Homework_7.Documents.documents;

import Homework_7.Documents.Document;

import java.util.Date;

public class ContractWithEmployee extends Document {

    private Date dateOfContractExpire;
    private String employeeName;

    public ContractWithEmployee(int number, Date documentDate) {
        super(number, documentDate);
    }

    public ContractWithEmployee(int number, Date documentDate, Date dateOfContractExpire, String employeeName) {
        super(number, documentDate);
        this.dateOfContractExpire = dateOfContractExpire;
        this.employeeName = employeeName;
    }

    @Override
    public void printDocInfo() {
        System.out.println("");
        System.out.printf("\nDocument number %d, \ndocument date %s, \ndate of contract expire %s, \nemployee name %s", this.number, this.documentDate, this.dateOfContractExpire, this.employeeName);
    }

    public Date getDateOfContractExpire() {
        return dateOfContractExpire;
    }

    public void setDateOfContractExpire(Date dateOfContractExpire) {
        this.dateOfContractExpire = dateOfContractExpire;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Contract with employee" +
                "\nnumber of document: " + number +
                "\ndocument's date: " + documentDate +
                "\ndate of contract expire: " + dateOfContractExpire +
                "\nemployee's name: " + employeeName;

    }

}
