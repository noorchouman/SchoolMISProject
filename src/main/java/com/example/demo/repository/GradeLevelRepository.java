package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.GradeLevel;

public interface GradeLevelRepository extends JpaRepository<GradeLevel, Long> {
	List<GradeLevel> findByNameContainingIgnoreCase(String namePart);
}
