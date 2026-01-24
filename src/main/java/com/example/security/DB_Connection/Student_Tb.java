package com.example.security.DB_Connection;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;



// name in the entity represent who you will call your class in code if you dont then it will use youe class name by default
@Entity()
@Table(name = "Student_Data",
    uniqueConstraints = {@UniqueConstraint(columnNames = "Stu_email")}
)
public class Student_Tb {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(
        name = "id",
// now id will never update
        updatable = false
    )
    private int id;

    @Column(
        name = "Stu_age",
// value cannot be null
        nullable =  false
    )
    private int age;

    @Column(
        name = "Stu_name",
// by default String is varchar(255) but when we say "Text" no it has no limit of storing
        columnDefinition = "Text",
        nullable = false
    )
    private String name;


    @Column(name = "Stu_email", nullable = false)
    private String email;
// constructor
    public Student_Tb(String name , int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

// no aurg constructor for hybernate
    public Student_Tb(){}

// for age
    public void setAge (int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
//for Srting name
    public void setName (String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

// for email
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
}









