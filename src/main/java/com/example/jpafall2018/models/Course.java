package com.example.jpafall2018.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {


	private Course(){}
	public Course(String title, Faculty author, List<Section> sections) {
		this.title = title;
		this.author = author;
		this.sections = sections;
	}

	public Course(String title, Faculty author) {
		this.title = title;
		this.author = author;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;

	@ManyToOne(	cascade = {CascadeType.ALL})
	private Faculty author;

	@OneToMany(mappedBy="course",orphanRemoval = true)
	private List<Section> sections;

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

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	public Faculty getAuthor() {
		return author;
	}

	public void setAuthor(Faculty author) {
		this.author = author;
	}
}
