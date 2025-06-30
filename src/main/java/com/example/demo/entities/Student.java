package com.example.demo.entities;

import java.io.Serial;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Student extends Person {
	@Serial
	private static final long serialVersionUID = 1L;
	private String classroomId;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable()
	private Set<Parent> parents;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(foreignKey = @ForeignKey(name = "FK_student_clubs_s"), inverseForeignKey = @ForeignKey(name = "FK_student_clubs_c"))
	private Set<Club> clubs;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "student")
	private Set<Result> results;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private GradeLevel gradeLevel;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "student")
	private Set<Registration> registrations;
}
