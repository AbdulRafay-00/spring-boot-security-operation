package com.example.security.DB_Connection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class UserAuth_DB {
    @Id
    private int id ;

    private String user_name;
    private String user_pass;


    UserAuth_DB(){}

    UserAuth_DB(String user_name, String user_pass){
        this.user_name = user_name;
        this.user_pass = user_pass;

    }
// getter setter for username
    public void setuser_name(String user_name){
        this.user_name = user_name;
    }

    public String getuser_name(){
        return user_name;
    }

// getter setter for userpass
    public void setuser_pass(String user_pass){
        this.user_pass = user_pass;
    }

    public String getuser_pass(){
        return user_pass;
    }

}
