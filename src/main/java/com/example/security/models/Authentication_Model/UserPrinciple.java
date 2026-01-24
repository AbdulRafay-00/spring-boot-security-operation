package com.example.security.models.Authentication_Model;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.security.DB_Connection.UserAuth_DB;

public class UserPrinciple implements UserDetails {
    UserAuth_DB userAuth_DB;

    public UserPrinciple(UserAuth_DB userAuth_DB){
        this.userAuth_DB = userAuth_DB;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    
        return Collections.singleton(new SimpleGrantedAuthority("user"));

    }

    @Override
    public @Nullable String getPassword() {
 
        return userAuth_DB.getuser_pass();
    }

    @Override
    public String getUsername() {

        return userAuth_DB.getuser_name();
    }
    
}
