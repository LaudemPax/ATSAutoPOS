/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.sales;

/**
 *
 * @author aman
 */
import com.openbravo.pos.ticket.TicketLineInfo;

//IMPORTANT getters must match names of fields
//Ex: field name: price
//    getter    : getPrice()

public class TicketLineInfoBean {

    //ticketline
    private String reference;
    private String code;
    private String name;
    private String memoDate;
    private String price;
    private String priceTax;
    private String multiply;
    private String value;
    private String taxRate;
    private String subValue;
    private String tax;
    private String printer;

    TicketLineInfo line;

    public TicketLineInfoBean(TicketLineInfo line){
        this.line = line;

        reference = line.printReference();
        code = line.printCode();
        name = line.printName();
        memoDate = line.getProductMemoDate();
        price = line.printPrice();
        priceTax = line.printPriceTax();
        multiply = line.printMultiply();
        value = line.printValue();
        taxRate = line.printTaxRate();
        subValue = line.printSubValue();
        tax = line.printTax();
        printer = line.printPrinter();

    }

    public String getReference(){

        if((reference == null) && (line.getProperty("productRef","") != "")){
            reference = line.getProperty("productRef","***");
        }

        return reference;
    };

    public String getCode() {

        if((code == null) && (line.getProperty("productCode","") != "")){
            code = line.getProperty("productCode","***");
        }

        return code;
    }

    public String getProductName() {
        return name;
    }

    public String getMemoDate() {
        return memoDate;
    }

    public String getPrice(){

        //discount support
        price = line.getProperty("originalPrice", price);

        return price;
    }

    public String getPriceTax() {

        //discount support
        priceTax = line.getProperty("originalPriceTax", priceTax);

        return priceTax;
    }

    public String getMultiply() {
        return multiply;
    }

    public String getValue() {
        return value;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public String getSubValue() {
        return subValue;
    }

    public String getTax() {
        return tax;
    }

    public String getPrinter() {
        return printer;
    }

}
