package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.io.Serial;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Student extends Person {
    @Serial
    private static final long serialVersionUID = 1L;
    private String classroomId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable()
    private Set<Parent> parents;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable()
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
