package com.example.security.crud_operetion;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.DB_Connection.Student_Tb;
import com.example.security.Repository.StudentRepository;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/get")
public class Get_Db {

    // private final Repository.StudentRepository studentRepository;
    private final StudentRepository studentRepository;
    @Autowired
    Get_Db(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/stu")
    public List<Student_Tb> getMethodRDB() {
        return studentRepository.findAll();
    }
    
    

//CSRF TOKEN FOR EXTERNAL BROWSER LIKE POST MAN BEC SERVER DOSENT SENT THE TOKEN TO THE POSTMAN
@GetMapping("/csrf")
    public CsrfToken csrf_token(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
