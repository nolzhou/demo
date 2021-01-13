package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author nolzhou
 * @desc ...
 * @date 2021-01-13 12:38:05
 */
@Controller
public class AdminController {

    @GetMapping(path="/adminLogin")
    public String adminLogin(){
        return "adminLogin";
    }

    @PostMapping(path="/adminLogin")
    public String processAdminLogin(@RequestParam(value = "adminName")String adminName,
                                    @RequestParam(value = "password")String password){
        return "";
    }
}
