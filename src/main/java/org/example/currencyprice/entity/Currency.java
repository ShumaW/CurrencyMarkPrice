package org.example.currencyprice.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Currency {

    String symbol;
    String markPrice;

    public String getSymbol() {
        return symbol;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }
}
