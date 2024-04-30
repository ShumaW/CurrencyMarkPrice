package org.example.currencyprice.controller;

import org.example.currencyprice.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{symbol}")
    public String getCurrencyMarkPrice(@PathVariable String symbol) {
        return currencyService.getCurrencyMarkPrice(symbol);
    }

}
