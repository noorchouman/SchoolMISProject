package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	List<Course> findByTeacherId(Long teacherId);

    List<Course> findByGradeLevelId(Long gradeLevelId);

    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
}
