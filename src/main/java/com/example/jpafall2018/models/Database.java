package com.example.jpafall2018.models;

import com.example.jpafall2018.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Database {


    private static UserRepository userRepository;
    private static StudentRepository studentRepository;
    private static FacultyRepository facultyRepository;
    @Autowired
    private static SectionRepository sectionRepository;
    private static EnrollmentRepository enrollmentRepository;


    public static void truncateAlltables() {
        sectionRepository.deleteAll();
        studentRepository.deleteAll();
        facultyRepository.deleteAll();
        userRepository.deleteAll();
        enrollmentRepository.deleteAll();

    }
}
