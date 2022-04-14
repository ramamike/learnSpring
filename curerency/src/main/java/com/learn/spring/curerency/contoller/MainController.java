package com.learn.spring.curerency.contoller;

import com.learn.spring.curerency.service.CurrencyParsing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) throws IOException {
        CurrencyParsing currencyParsing = new CurrencyParsing();
        List<List<String>> currencies = currencyParsing.getCurrencies();
        model.addAttribute("title", "Главная страница");
        model.addAttribute("currencies", currencies);
        return "home";
    }

}
