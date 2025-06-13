package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Department extends Auditable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    @EqualsAndHashCode.Exclude
    private Set<Staff> staffs;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private Staff head;
}

