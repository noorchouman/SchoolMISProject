package com.example.demo.entities;

import java.io.Serial;
import java.io.Serializable;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class Person extends Auditable implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    public Person() {}

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

}


