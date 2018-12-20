package com.boot.authentication.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class LoginController {

    @GetMapping("/login")
    public String viewLogin(){
        return "user/index";
    }
}
