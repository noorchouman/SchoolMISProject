package com.example.demo;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Teacher extends Staff {
	private String subject;
	
	 @OneToMany(mappedBy = "teacher")
	    private List<Course> courses;

	 @OneToMany(mappedBy = "teacher")
	    private List<Exam> exams;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
}

