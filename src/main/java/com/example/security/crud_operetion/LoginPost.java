package com.example.security.crud_operetion;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.DB_Connection.UserAuth_DB;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class LoginPost {
    @PostMapping("/login")
    public String postMethodName(@RequestBody UserAuth_DB userAuth_DB) {
        //TODO: process POST request
        
        return "success";
    }
    
}
