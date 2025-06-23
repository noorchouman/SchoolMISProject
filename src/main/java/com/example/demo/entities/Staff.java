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
public class Staff extends Person {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long mentorId;
    private Long salary;
    private String role;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Department department;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "head")
    private Department headOf;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "staff")
    private Set<Registration> registrations;
}
