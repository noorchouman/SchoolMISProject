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
public class Teacher extends Staff {
    @Serial
    private static final long serialVersionUID = 1L;

    private String subject;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "teacher")
    private Set<Exam> exams;
}
