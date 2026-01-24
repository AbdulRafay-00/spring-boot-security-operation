package com.example.security.crud_operetion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.DB_Connection.UserAuth_DB;
import com.example.security.models.Signup_model.SignUpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/signup")
public class SignUpPost {
    @Autowired
    SignUpService signUpService;
    @PostMapping("/user")
    public String sign_up_method(@RequestBody UserAuth_DB user) {
        String message =signUpService.register(user);
        return message;
    }
    
}
