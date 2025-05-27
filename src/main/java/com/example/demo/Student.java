package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Student extends Person {
	
    private String classroomId;

    @ManyToMany(mappedBy = "children")
    private List<Parent> parents;

    @ManyToMany
    private List<Club> clubs;

    @OneToMany(mappedBy = "student")
    private List<Result> results;

    @ManyToOne
    private GradeLevel gradeLevel;

    @OneToMany(mappedBy = "student")
    private List<Registration> registrations;

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

	public String getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}
}
