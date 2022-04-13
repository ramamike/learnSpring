package com.learn.spring.curerency.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class CurrencyParsing {

    public Document getPage() throws IOException{
//		String urlCurrency="http://www.cbr.ru/";
        String urlCurrency="https://belarusbank.by/be";
        Document page=Jsoup.parse(new URL(urlCurrency), 5000);
        return page;
    }
}
