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
public class Registration extends Auditable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Student student;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Staff staff;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Parent parent;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private GradeLevel gradeLevel;
}
