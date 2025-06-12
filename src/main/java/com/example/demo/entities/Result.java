package com.example.demo.entities;
import java.io.Serial;
import java.io.Serializable;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Result extends Auditable implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double score;
    private String gradeLetter;

    @ManyToOne
    private Student student;

    @OneToOne
    private Exam exam;

}
