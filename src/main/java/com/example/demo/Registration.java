package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Staff staff;

    @ManyToOne
    private Parent parent;

    @OneToOne
    private GradeLevel gradeLevel;

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Staff getStaff() {
        return staff;
    }

    public Parent getParent() {
        return parent;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}

