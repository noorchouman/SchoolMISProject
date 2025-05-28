package com.example.demo;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class GradeLevel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int level;
    private String name;

    @OneToMany(mappedBy = "gradeLevel")
    private Set<Student> students;
    
    @OneToOne(mappedBy = "gradeLevel")
    private Registration registration;
    
    @OneToMany(mappedBy = "gradeLevel")
    private Set<Course> courses;

    

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
