package com.example.security.crud_operetion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/signup")
public class SignUpPost {
    @PostMapping("/user")
    public String sign_up_method(@RequestBody String entity) {      
        return entity;
    }
    
}
