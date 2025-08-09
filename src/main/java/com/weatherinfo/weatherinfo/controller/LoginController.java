package com.weatherinfo.weatherinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {



    @GetMapping("/")
    public String homeRedirect() {

        return "redirect:/oauth2/authorization/auth0";
    }

}