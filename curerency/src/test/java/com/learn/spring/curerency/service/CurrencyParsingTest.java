package com.learn.spring.curerency.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class CurrencyParsingTest {

    @Autowired
    private CurrencyParsing currencyParsing;

    @Test
    public void testCurrencyParsing() throws IOException {

        System.out.println(currencyParsing.getPage());
        System.out.println("test");
    }

    @Test
    public void testParsTable(){

    }
}