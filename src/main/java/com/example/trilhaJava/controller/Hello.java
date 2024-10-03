package com.example.trilhaJava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class Hello {
    @GetMapping
    public String hello(){
        return "HelloWorld";
    }


}
