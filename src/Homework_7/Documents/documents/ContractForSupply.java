package Homework_7.Documents.documents;

import Homework_7.Documents.Document;

import java.util.Date;

public class ContractForSupply extends Document {

    private String goodsType;
    private int goodsQuantity;

    public ContractForSupply(int number, Date documentDate) {
        super(number, documentDate);
    }

    @Override
    public void printDocInfo() {
        System.out.println("");
        System.out.printf("\nDocument number %d, \ndocument date %s, \nproduct type %s, \ngoods quantity %d",this.number, this.documentDate,this.goodsType,this.goodsQuantity);
    }

    public ContractForSupply(int number, Date documentDate, String goodsType, int goodsQuantity) {
        super(number, documentDate);
        this.goodsType = goodsType;
        this.goodsQuantity = goodsQuantity;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(int goodsQuantity) {
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
