package org.example.currencyprice.service;

import org.example.currencyprice.entity.Currency;

public interface CurrencyService {

    Currency getCurrencyMarkPrice(String symbol);

}
