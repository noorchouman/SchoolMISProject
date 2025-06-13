package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GradeLevel extends Auditable implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int level;
    private String name;

    @OneToMany(mappedBy = "gradeLevel")
    private Set<Student> students;
    
    @OneToMany(mappedBy = "gradeLevel")
    private Set<Registration> registrations;
    
    @OneToMany(mappedBy = "gradeLevel")
    private Set<Course> courses;

}
