package com.ironhack.librarybookapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class GreetController {




    @GetMapping
    public String greet() {
        return "Hello, World!";
    }
}
