package com.example.demo.repository;

import com.example.demo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findBySubject(String subject);
    List<Teacher> findByNameContainingIgnoreCase(String name);
}
