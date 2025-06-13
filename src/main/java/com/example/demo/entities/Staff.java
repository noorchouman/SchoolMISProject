package com.example.demo.entities;

import java.io.Serial;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Staff extends Person {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long mentorId;
    private Long salary;
    private String role;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Department department;

    @OneToOne(mappedBy = "head")
    @EqualsAndHashCode.Exclude
    private Department headOf;

    @OneToMany(mappedBy = "staff")
    @EqualsAndHashCode.Exclude
    private Set<Registration> registrations;
}
