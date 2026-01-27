package com.example.security.models.Signup_model;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.security.DB_Connection.UserAuth_DB;

@Service
public class LoginService {
    @Autowired
    AuthenticationManager authenticationManager;

        @Autowired
    Jwt_Service jwt_Service;
    public String verify_user(UserAuth_DB user){
        
        try {
// bec it return ogj if exixt if not it throws exception ending the code bec of password intigrity it don want to tell weather user name or password any is correct 
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken( user.getUser_name(),user.getUser_pass()  ));

            // If we reached here, credentials are valid
            return jwt_Service.jwt_token_gen(user.getUser_name());

        } catch (Exception e) {
            // Any login failure (wrong username or password)
            return "Invalid username or password";
        }
    }
}
