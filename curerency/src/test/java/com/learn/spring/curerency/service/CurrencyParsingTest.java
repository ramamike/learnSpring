package com.learn.spring.curerency.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class CurrencyParsingTest {

    private CurrencyParsing currencyParsing= new CurrencyParsing();


    @Test
    public void testGetCurrencies()  {
        List<List<String>> currencies = currencyParsing.getCurrencies();
        for (List<String> currency: currencies
            ) {
                for (String entry: currency
                ) {
                    System.out.print(entry + "\t\t");
                }
                System.out.println();
            }

    }

}
