package com.example.demo;
import jakarta.persistence.*;


import java.util.Set;

@Entity
public class Club {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "clubs")
    private Set<Student> members;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getMembers() {
		return members;
	}

	public void setMembers(Set<Student> members) {
		this.members = members;
	}
}
