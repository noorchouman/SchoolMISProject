package com.example.demo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Result {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double score;
    private String gradeLetter;
    private String comments;

    @ManyToOne
    private Student student;

    @OneToOne
    private Exam exam;

}
