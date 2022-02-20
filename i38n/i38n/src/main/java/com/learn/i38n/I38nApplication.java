package com.learn.i38n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@SpringBootApplication
public class I38nApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(I38nApplication.class, args);
	}

	/*
	 * Resolves the locale and stores it in a cookie stored on the user’s machine
	 */
	@Bean // <--- 1
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver(); // <--- 2
		localeResolver.setDefaultLocale(Locale.US); // <--- 3
		return localeResolver;
	}

	/*
	 * Bean will intercept each request that the application receives,
	 * and check for a localeData parameter on the HTTP request.
	 * If found, the interceptor uses the localeResolver that is coded earlier
	 * to register the locale it found as the current user’s locale.
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		// Defaults to "locale" if not set
		localeChangeInterceptor.setParamName("localeData");

		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}

}
