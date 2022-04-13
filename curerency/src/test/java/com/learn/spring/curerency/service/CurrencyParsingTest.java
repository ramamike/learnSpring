package com.learn.spring.curerency.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
    public void testParsTable() throws IOException {
        Document page = currencyParsing.getPage();
        Element currencyTable = page.select("table[class=currency-table currency-table--row-sm]")
                .first();
        Elements currencyRows = currencyTable.select("tr");
        /**
         <tr>
         <td class="currency-table__cell-curr"> <strong>1 долар ЗША</strong> </td>
         <td class="currency-table__cell-value"> 2.7600 </td>
         <td class="currency-table__cell-value"> 2.8600 </td>
         </tr>
         */
        System.out.println("currency\t\t\t\t " + "purchase\t\t\t\t" + "sale");
        for (Element row : currencyRows
        ) {
            Elements currencyInf = row.select("td");
            for (Element elementInf : currencyInf
            ) {
                System.out.print(elementInf.text() + " \t\t\t\t ");
            }
            System.out.println();
        }
    }

    @Test
    public void testToArray() throws IOException {
        Document page=currencyParsing.getPage();
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

        //Test print

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
