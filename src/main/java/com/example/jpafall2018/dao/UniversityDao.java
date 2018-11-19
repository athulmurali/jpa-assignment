package com.example.jpafall2018.dao;

import com.example.jpafall2018.models.*;
import com.example.jpafall2018.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UniversityDao  implements UniversityInterface {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    EnrollmentRepository  enrollmentRepository;


    @Override
    public void truncateDatabase() {
        courseRepository.deleteAll();
        studentRepository.deleteAll();
        enrollmentRepository.deleteAll();
        facultyRepository.deleteAll();
        studentRepository.deleteAll();
        sectionRepository.deleteAll();
        userRepository.deleteAll();


    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Course createCourse(Course course) {
         courseRepository.save(course);
        return course;
    }

    @Override
    public Section createSection(Section section) {

        sectionRepository.save(section);
        return section;
    }

    @Override
    public Course addSectionToCourse(Section section, Course course) {
        Optional<Section> currentSection = sectionRepository.findById(section.getId());

        if(currentSection.isPresent())
        {
            section = currentSection.get();
            section.setCourse(course);
            sectionRepository.save(section);
            return  course;

        }

        return course;
    }
    @Override
    public Course setAuthorForCourse(Faculty faculty, Course course) {

        System.out.println("Course : " + course.getId() + ", Section : " + faculty.getId());
        Optional<Course> courseFound    = courseRepository.findById(course.getId());
        Optional<Faculty> facultyFound  = facultyRepository.findById(course.getId());
        if(courseFound.isPresent() && facultyFound.isPresent()) {
            course = courseFound.get();
            faculty = facultyFound.get();
            course.setAuthor(faculty);

            courseRepository.save(course);
            return course;
        }

        return course;

    }

    @Override
    public Boolean enrollStudentInSection(Student student, Section section) {

        Optional<Section> sectionOptional = sectionRepository.findById(section.getId());
        Optional<Student> studentOptional = studentRepository.findById(student.getId());
        if(sectionOptional.isPresent() && studentOptional.isPresent()) {
            section = sectionOptional.get();
            student = studentOptional.get();
            int remainingSeats = section.getSeats();
            if(remainingSeats <= 0)
                return false;
            section.setSeats(remainingSeats-1);
            sectionRepository.save(section);

            Enrollment enrollment = new Enrollment( student, section);
            enrollment.setFeedback(null);
            enrollmentRepository.save(enrollment);
            return true;
        }
        return  false;
    }



    //finder methods

    @Override
    public List<Person> findAllUsers() {
        return null;
    }



    @Override
    public List<Faculty> findAllFaculty() {
        return (List<Faculty>) facultyRepository.findAll();
    }

    @Override
    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public List<Section> findAllSections() {
        return (List<Section>) sectionRepository.findAll();
    }

    @Override
    public List<Course> findCoursesForAuthor(Faculty faculty) {
        return faculty.getAuthoredCourses();
    }

    @Override
    public List<Section> findSectionForCourse(Course course) {
        return  course.getSections();
    }

    @Override
    public List<Student> findStudentsInSection(Section section) {
        return null;
    }

    @Override
    public List<Section> findSectionsForStudent(Student student) {
        return null;
    }





}
