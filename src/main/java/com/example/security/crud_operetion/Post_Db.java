package com.example.security.crud_operetion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.DB_Connection.Student_Tb;
import com.example.security.Repository.StudentRepository;

import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/post")
public class Post_Db {
    StudentRepository studentRepository;
    Post_Db(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @PostMapping("/stu")
    public String postMethodName(@RequestBody Student_Tb student_Tb) {
    studentRepository.findByEmail(student_Tb.getEmail());
    
    if (studentRepository.findByEmail(student_Tb.getEmail()).isPresent()) {
        return"Student email already present ";
    }else{
        studentRepository.save(student_Tb);
        
        return "Added";
    }
    }
    
}
