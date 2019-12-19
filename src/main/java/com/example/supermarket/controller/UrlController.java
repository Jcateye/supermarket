package com.example.supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {

    @RequestMapping("/index")
    public String index (){
        return "index";
    }

    @RequestMapping("/book")
    public String book (){
        return "bookinfo";
    }
}
