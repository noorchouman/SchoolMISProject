package com.example;
import jakarta.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class GradeLevel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int level;
    private String name;

    @OneToMany(mappedBy = "gradeLevel")
    private Set<Student> students;

}
