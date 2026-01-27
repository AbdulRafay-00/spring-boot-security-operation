package com.example.security.crud_operetion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.DB_Connection.UserAuth_DB;
import com.example.security.models.Signup_model.Jwt_Service;
import com.example.security.models.Signup_model.LoginService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class LoginPost {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String postMethodName(@RequestBody UserAuth_DB userAuth_DB) {

        return loginService.verify_user(userAuth_DB);
    }
    
}
