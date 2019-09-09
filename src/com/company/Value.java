package com.company;

public class Value {

    private String baseCurrency;
    private String currency;
    private double saleRateNB;
    private double purchaseRateNB;

    public Value() {
    }

    public String getCurrency() {
        return currency;
    }

    public double getSaleRateNB() {
        return saleRateNB;
    }

    public double getPurchaseRateNB() {
        return purchaseRateNB;
    }

    @Override
    public String toString() {
        return "Value{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", currency='" + currency + '\'' +
                ", saleRateNB=" + saleRateNB +
                ", purchaseRateNB=" + purchaseRateNB +
                '}';
    }
}
