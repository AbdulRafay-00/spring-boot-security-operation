package com.example.security.Filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.security.DB_Connection.UserAuth_DB;
import com.example.security.models.Authentication_Model.MyUserDetailService;
import com.example.security.models.Authentication_Model.UserPrinciple;
import com.example.security.models.Signup_model.Jwt_Service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    Jwt_Service jwt_Service;

    @Autowired
    ApplicationContext context;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                String authHeader = request.getHeader("Authorization");
                String token = null;
                String userName = null;

                if (authHeader != null) {
// Why subString seven because first 7 character are not part of the token
// Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwb29sIiwiaWF0IjoxNzY5NTIxODgwLCJleHAiOjE3Njk1MjE5NDB9.lSKYN-eiBtGtoGQyEbp_RNWjSNCIklFC4_UoZ3vaXT0
                    token = authHeader.substring(7);
                    userName = jwt_Service.extractUserName(token);
                }

                if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = context.getBean(MyUserDetailService.class).loadUserByUsername(userName);
                    
                    if (jwt_Service.validateToken(token, userDetails)) {
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null , userDetails.getAuthorities());
                            
                            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authToken);
                        }
                        System.out.println(userName+ "lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
                        System.out.println(userDetails.getPassword());
                        System.out.println(userDetails);
                    }
                    
                filterChain.doFilter(request, response);

    }
    
}
