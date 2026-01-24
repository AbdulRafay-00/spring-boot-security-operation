package com.example.security.models.Signup_model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.DB_Connection.UserAuth_DB;
import com.example.security.Repository.UserAuthRepository;


@Service
public class SignUpService {

    @Autowired
    UserAuthRepository userAuthRepository;

    public String register(UserAuth_DB user){

        // if (userAuthRepository.findByUser_name(user.getuser_name()).isPresent()) {
        //     return "Username already exists";
        // }

        userAuthRepository.save(user);
        return "Registered successfully";
    }
}
