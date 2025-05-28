package com.example.demo.repository;

import com.example.demo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassroomId(String classroomId);
    List<Student> findByGradeLevelId(Long gradeLevelId);
    List<Student> findByNameContainingIgnoreCase(String name);
}
