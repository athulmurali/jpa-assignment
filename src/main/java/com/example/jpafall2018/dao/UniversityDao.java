package com.example.jpafall2018.dao;

import com.example.jpafall2018.models.*;
import com.example.jpafall2018.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
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
        Optional<Course> courseFound= courseRepository.findById(course.getId());
        if(courseFound.isPresent()) {
            course = courseFound.get();
        }
        course.setAuthor(faculty);

        courseRepository.save(course);

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
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
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
        Optional<Section> sectionOptional = sectionRepository.findById(section.getId());
        if(sectionOptional.isPresent()) {
            List<Enrollment> enrollments = section.getEnrollments();

            List<Student> studentsList = new ArrayList<>();

            for (Enrollment enrollment : enrollments)
                studentsList.add(enrollment.getStudent());

            return  studentsList;
        }
         return null;

    }

    @Override
    public List<Section> findSectionsForStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findById(student.getId());
        if(studentOptional.isPresent()) {

            Student studentFound = studentOptional.get();
            List<Enrollment> enrollments = studentFound.getEnrollments();

            List<Section> sectionsList = new ArrayList<>();

            for (Enrollment enrollment : enrollments)
                sectionsList.add(enrollment.getSection());

            return  sectionsList;
        }

        return  null;

    }





}
