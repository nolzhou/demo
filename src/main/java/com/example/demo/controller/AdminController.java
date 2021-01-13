package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nolzhou
 * @desc ...
 * @date 2021-01-13 12:38:05
 */
@Controller
public class AdminController {

    @GetMapping(path="/adminlogin")
    public String adminlogin(){
        return "adminlogin";
    }
}
