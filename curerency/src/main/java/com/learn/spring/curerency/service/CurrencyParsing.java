package com.learn.spring.curerency.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class CurrencyParsing {

    //private final String urlCurrency="http://www.cbr.ruu/";
    private final String urlCurrency="https://belarusbank.by/be";

    private List<List<String>> storedCurrencies;

    public Document getPage() throws IOException{
        Document page=Jsoup.parse(new URL(urlCurrency), 5000);
        return page;
    }

    public List<List<String>> getCurrencies(){

        Document page= null;
        try {
            page = Jsoup.parse(new URL(urlCurrency), 5000);
        } catch (IOException e) {
            System.out.println(e.getMessage() + " is not available");
            return null;
        }

        if(page==null) {
            return null;
        }

        Element currencyTable=page.select("table[class=currency-table currency-table--row-sm]")
                .first();

        if(currencyTable==null) {
            return null;
        }

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

    @Scheduled(fixedRate = 5000)
    private void setStoredCurrencies() {
        this.storedCurrencies=getCurrencies();
        //System.out.println("currencies are stored");
    }

    public List<List<String>> getStoredCurrencies() {
        return storedCurrencies;
    }
}
