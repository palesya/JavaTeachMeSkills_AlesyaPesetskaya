package homework_7.Documents;

import homework_7.Documents.documents.ContractForSupply;
import homework_7.Documents.documents.ContractWithEmployee;
import homework_7.Documents.documents.FinancialInvoice;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Document contractForSupply = new ContractForSupply(12, new Date(), "Milk", 300);
        Document financialInvoice = new FinancialInvoice(18, new Date(), 3567, "QA12");
        Document contractWithEmployee = new ContractWithEmployee(34, new Date(), new Date(), "Ivan Ivanov");

        Register register = new Register();

        Document[] documents = {contractForSupply, financialInvoice, contractWithEmployee};
        for (Document el : documents) {
            System.out.println("------------------------------");
            register.saveDocInRegister(el);
        }
        register.printDocs();
    }
}
