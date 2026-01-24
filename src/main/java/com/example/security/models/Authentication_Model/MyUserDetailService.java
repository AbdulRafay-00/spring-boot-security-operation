package com.example.security.models.Authentication_Model;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.DB_Connection.UserAuth_DB;
import com.example.security.Repository.UserAuthRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;

    public MyUserDetailService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String user_name) {

        UserAuth_DB user = userAuthRepository
                .findByUser_name(user_name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new UserPrinciple(user);
    }
}
