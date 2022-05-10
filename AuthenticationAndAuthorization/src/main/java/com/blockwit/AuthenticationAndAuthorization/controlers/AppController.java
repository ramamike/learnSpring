package com.blockwit.AuthenticationAndAuthorization.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/authenticated")
    public String au() {
        return "authenticated";
    }
}
