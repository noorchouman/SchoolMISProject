package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Parent extends Person {
	
	private String phoneNumber;


    @ManyToMany
    private List<Student> children;

    @OneToMany(mappedBy = "parent")
    private List<Registration> registrations;

    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
