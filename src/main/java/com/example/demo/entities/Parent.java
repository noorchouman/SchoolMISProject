package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Parent extends Person {
	@Serial
	private static final long serialVersionUID = 1L;

	private String phoneNumber;


    @ManyToMany
    private List<Student> children;

    @OneToMany(mappedBy = "parent")
    private List<Registration> registrations;

}
