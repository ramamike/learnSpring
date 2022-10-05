package com.learn.i38n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String hello() { // <--- 1
        return "hello"; // <--- 2
    }
}