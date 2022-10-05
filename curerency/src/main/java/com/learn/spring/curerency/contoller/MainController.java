package com.learn.spring.curerency.contoller;

import com.learn.spring.curerency.service.CurrencyParsing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {


    @Autowired
    public MainController(CurrencyParsing currencyParsing) {
        this.currencyParsing = currencyParsing;
    }

    private CurrencyParsing currencyParsing;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/currencies")
    public String currencies(Model model) {
        List<List<String>> currencies = currencyParsing.getStoredCurrencies();
        model.addAttribute("currencies", currencies);
        return "currencies";
    }

}
