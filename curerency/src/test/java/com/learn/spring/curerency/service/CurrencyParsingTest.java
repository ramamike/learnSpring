package com.learn.spring.curerency.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class CurrencyParsingTest {

    @Test
    public void testCurrencyParsing() throws IOException {

        CurrencyParsing currencyParsing=new CurrencyParsing();
        System.out.println(currencyParsing.getPage());
        System.out.println("test");
    }

}