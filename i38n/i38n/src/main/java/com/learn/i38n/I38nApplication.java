package com.learn.i38n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;


@SpringBootApplication
public class I38nApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(I38nApplication.class, args);


		System.out.println(Locale.getDefault().getLanguage());
		System.out.println(LocaleContextHolder.getLocale().getLanguage());
		System.out.println(System.getProperty("user.language"));

	}
}
