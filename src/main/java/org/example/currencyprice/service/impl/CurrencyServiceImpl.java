package org.example.currencyprice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.currencyprice.entity.Currency;
import org.example.currencyprice.service.CurrencyService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private static final String CURRENCY_API = "https://fapi.binance.com/fapi/v1/premiumIndex";

    @Override
    public Currency getCurrencyMarkPrice(String string) {
        Currency currency = new Currency();
        JSONArray jsonArray = getCurrencyList(CURRENCY_API);
        String symbol = "";
        String markPrice = "";
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            symbol = jsonObject.getString("symbol");
            if (symbol.equals(string)) {
                markPrice = jsonObject.getString("markPrice");
            }
        }
        currency.setSymbol(string);
        currency.setMarkPrice(markPrice);
        return currency;
    }

    private JSONArray getCurrencyList(String currencyUrl) {
        Scanner scanner;
        try {
            URL url = new URL(currencyUrl);
            scanner = new Scanner((InputStream) url.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder response = new StringBuilder();
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        String resultString = response.toString();
        return new JSONArray(resultString);
    }
}
