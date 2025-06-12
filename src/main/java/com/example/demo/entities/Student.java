package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Student extends Person {
	
	@Serial
	private static final long serialVersionUID = 1L;
    private String classroomId;

    @ManyToMany
	@JoinTable()
	private Set<Parent> parents;

	@ManyToMany
	@JoinTable()
	private Set<Club> clubs;
	
    @OneToMany(mappedBy = "student")
    private Set<Result> results;

    @ManyToOne
    private GradeLevel gradeLevel;

    @OneToMany(mappedBy = "student")
    private Set<Registration> registrations;
}
