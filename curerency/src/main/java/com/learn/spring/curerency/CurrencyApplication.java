package com.learn.spring.curerency;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class CurrencyApplication {

	private static Document getPage() throws IOException {
//		String urlCurrency="http://www.cbr.ru/";
		String urlCurrency="https://belarusbank.by/en";
		Document page= Jsoup.parse(new URL(urlCurrency), 5000);
		return page;
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CurrencyApplication.class, args);

		System.out.println(getPage());
	}

}
