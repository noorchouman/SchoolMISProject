package com.example.demo.entities;

import java.io.Serial;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Teacher extends Staff {
	@Serial
	private static final long serialVersionUID = 1L;
	
	private String subject;
	
	 @OneToMany(mappedBy = "teacher")
	private Set<Course> courses;

	
	 @OneToMany(mappedBy = "teacher")
	    private Set<Exam> exams;
}

