package Homework_7.Documents;

import java.util.Date;

public class ContractForSupply extends Document {

    private String goodsType;
    private int goodsQuantity;

    public ContractForSupply(int number, Date documentDate) {
        super(number, documentDate);
    }

    public ContractForSupply(int number, Date documentDate, String goodsType, int goodsQuantity) {
        super(number, documentDate);
        this.goodsType = goodsType;
        this.goodsQuantity = goodsQuantity;
    }

    @Override
    public String toString() {
        return "Contract for supply:" +
                "\nnumber of document: " + number +
                "\ndocument's date: " + documentDate +
                "\ntype of goods is " + goodsType +
                "\nquantity = " + goodsQuantity;
    }
}
