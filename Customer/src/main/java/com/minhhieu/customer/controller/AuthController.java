package com.minhhieu.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "signup";
    }
}
