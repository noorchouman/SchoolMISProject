package com.example.demo;
import jakarta.persistence.*;
@Entity

public class Result {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double score;
    private String gradeLetter;

    @ManyToOne
    private Student student;

    @OneToOne
    private Exam exam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getGradeLetter() {
		return gradeLetter;
	}

	public void setGradeLetter(String gradeLetter) {
		this.gradeLetter = gradeLetter;
	}

	
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
