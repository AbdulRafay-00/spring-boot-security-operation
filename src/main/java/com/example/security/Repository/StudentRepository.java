package com.example.security.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.DB_Connection.Student_Tb;



@Repository
public interface StudentRepository extends JpaRepository<Student_Tb, Integer> {
    Optional<Student_Tb> findByEmail(String email);
}
