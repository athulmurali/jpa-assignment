package com.example.jpafall2018.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends User {
  private String office;
  private Boolean tenure;

  @OneToMany(mappedBy="author", fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
  private List<Course> authoredCourses;

  public void authoredCourse(Course course) {
     this.authoredCourses.add(course);
     if(course.getAuthor() != this)
        course.setAuthor(this);
  }


  public Faculty() {}
	public Faculty(String u, String p, String f, String l, String office, boolean tenured) {
		super(u, p, f, l);
		this.office = office;
		this.tenure = tenured;
	}



	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenure() {
		return tenure;
	}
	public void setTenure(Boolean tenure) {
		this.tenure = tenure;
	}
	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}
	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}
	public void addCourse(Course course) {
		this.authoredCourses.add(course);
	}

	public void removeCourse(Course course  ) {
		this.authoredCourses.remove(course);
	}



}
