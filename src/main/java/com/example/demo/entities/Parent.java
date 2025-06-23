package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.io.Serial;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Parent extends Person {
    @Serial
    private static final long serialVersionUID = 1L;

    private String phoneNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    private List<Student> children;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "parent")
    private List<Registration> registrations;
}
