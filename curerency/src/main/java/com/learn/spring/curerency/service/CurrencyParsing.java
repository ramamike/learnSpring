package com.learn.spring.curerency.service;

import org.apache.catalina.Manager;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@EnableScheduling
public class CurrencyParsing {

    private static final Logger logger= LoggerFactory.getLogger(Manager.class);

//    private final String urlCurrency="http://www.cbr.ru/";
    private final String urlCurrency="https://belarusbank.by/be";

    private volatile List<List<String>> storedCurrencies;


    @Scheduled(fixedRate = 5000)
    private void setStoredCurrencies() {

        Document page = null;
        try {
            page = Jsoup.parse(new URL(urlCurrency), 5000);
        } catch (IOException e) {
            logger.warn("Problem with https://belarusbank.by/be ", e);
        }

        if(page==null) {
            logger.info("Document page is null, parsing is not done for URL");
            return;
        }
        Element currencyTable = page.select("table[class=currency-table currency-table--row-sm]")
                    .first();

        if(currencyTable==null) {
            logger.info("HTML parsed doesn't consist the requested cssQuery");
            return;
        }
        Elements currencyRows = currencyTable.select("tr");

        List<List<String>> currencies= new ArrayList<>();

        for (Element elementRow: currencyRows) {
            List<String> currencyTableEntries = new ArrayList<>();
            Elements currencyEntry = elementRow.select("td");
            for (Element elementEntry: currencyEntry) {
                currencyTableEntries.add(elementEntry.text());
            }
            currencies.add(currencyTableEntries);
        }

        this.storedCurrencies=currencies;
//        System.out.println("currencies are stored");
    }

    public List<List<String>> getStoredCurrencies() {
        return storedCurrencies;
    }
}
