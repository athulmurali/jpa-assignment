package com.example.jpafall2018.dao;

import com.example.jpafall2018.models.*;

import java.util.List;

public interface UniversityInterface {
//    removes all the data from the database. Note that you might need to remove records in a particular order
    void truncateDatabase();
    Faculty createFaculty(Faculty faculty);
    Student createStudent(Student student);
    Course createCourse(Course course);
    Section createSection(Section section);
    Course addSectionToCourse(Section section, Course course);
    Course setAuthorForCourse(Faculty faculty, Course course);
     // enrolls a student in a section updating the number of seats available and returning true. If the current available seats is zero then the enrollment is refused and method returns false
     Boolean enrollStudentInSection(Student student, Section section);



     //finder methods
     List<Person> findAllUsers();
    List<Faculty> findAllFaculty();
    List<Student> findAllStudents();
    List<Course> findAllCourses();
    List<Section> findAllSections();
    List<Course> findCoursesForAuthor(Faculty faculty);
    List<Section> findSectionForCourse(Course course);
    List<Student> findStudentsInSection(Section section);
    List<Section> findSectionsForStudent(Student student);

}
