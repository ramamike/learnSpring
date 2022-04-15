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
    private long counterOfUpdating =0L;


    @GetMapping("/")
    public String home(Model model) {
        List<List<String>> currencies = currencyParsing.getCurrencies();
        model.addAttribute("title", "Главная страница");
        model.addAttribute("currencies", currencies);
        model.addAttribute("currentTime", counterOfUpdating++);
        return "home";
    }

}
