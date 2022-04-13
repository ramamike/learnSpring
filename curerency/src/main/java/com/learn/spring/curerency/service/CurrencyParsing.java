package com.learn.spring.curerency.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyParsing {

    //private final String urlCurrency="http://www.cbr.ru/";
    private final String urlCurrency="https://belarusbank.by/be";

    public Document getPage() throws IOException{
        Document page=Jsoup.parse(new URL(urlCurrency), 5000);
        return page;
    }

    public List<List<String>> getCurrencies() throws IOException {
        Document page=Jsoup.parse(new URL(urlCurrency), 5000);
        Element currencyTable=page.select("table[class=currency-table currency-table--row-sm]")
                .first();

        Elements currencyRows=currencyTable.select("tr");
        List<List<String>> currencies= new ArrayList<>();

        for (Element elementRow: currencyRows
        ) {
            List<String> currencyTableEntries = new ArrayList<>();
            Elements currencyEntry = elementRow.select("td");
            for (Element elementEntry: currencyEntry
            ) {
                currencyTableEntries.add(elementEntry.text());
            }
            currencies.add(currencyTableEntries);
        }

        return currencies;
    }
}
