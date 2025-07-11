package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Result extends Auditable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double score;
    private String gradeLetter;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Student student;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    private Exam exam;
}
