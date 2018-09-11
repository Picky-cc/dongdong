package com.dongdong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @PostMapping("/index")
    public String index(){
        return "index";
    }
}
