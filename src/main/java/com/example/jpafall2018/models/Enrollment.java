package com.example.jpafall2018.models;

import javax.persistence.*;

@Entity
public class Enrollment {
    Enrollment(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int grade;
    private String feedback;



    @ManyToOne(fetch= FetchType.EAGER)
    private Student student;


    @ManyToOne(fetch= FetchType.EAGER)
    private Section section;

    public Enrollment(int id, int grade, String feedback, Student student, Section section) {
        this.id = id;
        this.grade = grade;
        this.feedback = feedback;
        this.student = student;
        this.section = section;
    }

    public Enrollment( Student student, Section section) {
        this.grade = 0;
        this.feedback = null;
        this.student = student;
        this.section = section;
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
