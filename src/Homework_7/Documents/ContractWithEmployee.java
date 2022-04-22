package Homework_7.Documents;

import java.util.Date;

public class ContractWithEmployee extends Document {

    private String dateOfContractExpire;
    private String employeeName;

    public ContractWithEmployee(int number, Date documentDate) {
        super(number, documentDate);
    }

    public ContractWithEmployee(int number, Date documentDate, String dateOfContractExpire, String employeeName) {
        super(number, documentDate);
        this.dateOfContractExpire = dateOfContractExpire;
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
