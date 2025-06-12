package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
	List<Exam> findByCourseId(Long courseId);

	Page<Exam> findByAuditCreatedDateAfter(LocalDateTime date, Pageable pageable);
}