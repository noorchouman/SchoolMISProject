package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Exam extends Auditable implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToOne
    private Course course;
    
    @ManyToOne
    private Teacher teacher;
    
    @OneToOne(mappedBy = "exam")
    private Result result;

}
