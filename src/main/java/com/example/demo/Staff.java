package com.example.demo;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class Staff extends Person {
	
	private Long mentorId;
    private Long salary;
    private String role;

    @ManyToOne
    private Department department;

    @OneToOne(mappedBy = "head")
    private Department headOf;
    
    @OneToMany(mappedBy = "staff")
    private List<Registration> registrations;


    public Department getDepartment() {
        return department;
    }

    public Department getHeadOf() {
        return headOf;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setHeadOf(Department headOf) {
        this.headOf = headOf;
    }
    
    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

	public Long getMentorId() {
		return mentorId;
	}

	public void setMentorId(Long mentorId) {
		this.mentorId = mentorId;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}


