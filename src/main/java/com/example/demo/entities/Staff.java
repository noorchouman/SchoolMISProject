package com.example.demo.entities;

import java.io.Serial;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Staff extends Person {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private Long mentorId;
    private Long salary;
    private String role;

    @ManyToOne
    private Department department;

    @OneToOne(mappedBy = "head")
    private Department headOf;
    
    @OneToMany(mappedBy = "staff")
    private Set<Registration> registrations;


}


