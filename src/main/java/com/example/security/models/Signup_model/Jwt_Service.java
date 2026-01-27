package com.example.security.models.Signup_model;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class Jwt_Service {
    private String signeture;
    public Jwt_Service(){
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sign = keygen.generateKey();
            signeture = Base64.getEncoder().encodeToString(sign.getEncoded());
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }



    public String jwt_token_gen(String userName){
        HashMap <String , Object> clai = new HashMap<>();
        return Jwts.builder()
        .claims()
        .add(clai)
        .subject(userName)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 60 * 1000))
        .and()
        .signWith(getkey())
        .compact();
        
    }

    private Key getkey(){
        byte[] bytekey = Decoders.BASE64.decode(signeture);
        return Keys.hmacShaKeyFor(bytekey);
    }
}
