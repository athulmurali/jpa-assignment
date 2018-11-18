package com.example.jpafall2018;

import com.example.jpafall2018.models.Student;
import com.example.jpafall2018.repositories.StudentRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class StudentTest {

    @Autowired
    StudentRepository sr;

    @Test
    public void enrollSection() {
    }

    @Test
    public void getGraduatingYear() {
    }

    @Test
    public void setGraduatingYear() {
    }

    @Test
    public void isHasGrant() {
    }

    @Test
    public void setHasGrant() {
    }

    @Test
    public void setEnrolledSections() {
    }

    @Test
    public void findAllStudents(){
        Iterable<Student> students = sr.findAll();

        for(Student student : students){
            System.out.print(student.toString());
        }
    }
}
