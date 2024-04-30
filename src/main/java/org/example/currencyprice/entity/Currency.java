package org.example.currencyprice.entity;

public class Currency {

    String symbol;
    Double markPrice;

    public Currency(String symbol, Double markPrice) {
        this.symbol = symbol;
        this.markPrice = markPrice;
    }

    public Currency(String symbol) {
        this.symbol = symbol;
    }

    public Currency(Double markPrice) {
        this.markPrice = markPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getMarkPrice() {
        return markPrice;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setMarkPrice(Double markPrice) {
        this.markPrice = markPrice;
    }
}
