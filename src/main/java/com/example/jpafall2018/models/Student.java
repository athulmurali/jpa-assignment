package com.example.jpafall2018.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Student extends User {
	private int graduatingYear;
	private Long scholarship;

	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "student",
			orphanRemoval = true,fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)


	private List<Enrollment> enrollments = new ArrayList<>();

	private Student(){}
	public Student(String username, String password,
				   String first, String last, int graduatingYear,
				   Long scholarship) {
		super(username, password, first, last);
		this.graduatingYear = graduatingYear;
		this.scholarship = scholarship;
	}


	public int getGraduatingYear() {
		return graduatingYear;
	}
	public void setGraduatingYear(int graduatingYear) {
		this.graduatingYear = graduatingYear;
	}


	public Long getScholarship() {
		return scholarship;
	}

	public void setScholarship(Long scholarship) {
		this.scholarship = scholarship;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
}
