package com.example.jpafall2018.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
public class Section {

	Section(){}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private int seats;


	public Section(String title, int seats, Course course) {
		this.title = title;
		this.seats = seats;
		this.course = course;
	}



	public Section(String title, int seats) {
		this.title = title;
		this.seats = seats;
		this.course = course;
	}
	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonIgnore
	private Course course;



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
