package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Result;
@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
	List<Result> findByStudentId(Long studentId);
	
	List<Result> findByExamId(Long examId);
	
	List<Result> findByScoreGreaterThanEqual(Double score);
	
	@Query("SELECT r.gradeLetter, AVG(r.score) FROM Result r GROUP BY r.gradeLetter")
	List<Object[]> findAverageScoreGroupedByGradeLetter();
}
