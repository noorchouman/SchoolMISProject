package com.example.demo.repository;

import com.example.demo.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByStudentId(Long studentId);
    List<Registration> findByParentId(Long parentId);
    List<Registration> findByStaffId(Long staffId);
}
