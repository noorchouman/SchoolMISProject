package com.example.demo.repository;

import com.example.demo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByRole(String role);
    List<Staff> findByDepartmentId(Long departmentId);
    List<Staff> findByNameContainingIgnoreCase(String name);
}
