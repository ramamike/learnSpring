package com.blockwit.learnSpring.ramamike;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String index() {
        return "\nHello world! \n\n";
    }

}