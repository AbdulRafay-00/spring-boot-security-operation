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

    UserAuth_DB(String user_name, String user_pass, int id){
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.id = id;
    }
// getter setter for username
    public void setUser_name(String user_name){
        this.user_name = user_name;
    }

    public String getUser_name(){
        return user_name;
    }

// getter setter for userpass
    public void setUser_pass(String user_pass){
        this.user_pass = user_pass;
    }

    public String getUser_pass(){
        return user_pass;
    }

    public int getId(){
        return id;
    }
    
}
