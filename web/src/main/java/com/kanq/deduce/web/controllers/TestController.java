package com.kanq.deduce.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/") 
    public String home(){
        return "hello world";
    }
    
}
