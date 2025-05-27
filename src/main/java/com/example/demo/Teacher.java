package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class Teacher extends Staff {
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}

