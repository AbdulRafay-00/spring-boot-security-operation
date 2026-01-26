package com.example.security.models.Signup_model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.DB_Connection.UserAuth_DB;
import com.example.security.Repository.UserAuthRepository;


@Service
public class SignUpService {

    @Autowired
    UserAuthRepository userAuthRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public String register(UserAuth_DB user){

        if (userAuthRepository.findById(user.getId()).isPresent()) {
            return "Username already exists";
        }
        user.setUser_pass(encoder.encode(user.getUser_pass()));

        userAuthRepository.save(user);
        return "Registered successfully";
    }
}
