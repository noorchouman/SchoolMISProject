package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassroomId(String classroomId);
    List<Student> findByGradeLevelId(Long gradeLevelId);
    List<Student> findByNameContainingIgnoreCase(String name);
}
