package com.example.jpafall2018.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student extends User {
	private int graduatingYear;
	private Long scholarship;


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
}
