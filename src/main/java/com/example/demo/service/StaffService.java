package com.example.demo.service;

import com.example.demo.Staff;
import java.util.List;

public interface StaffService {
    List<Staff> getAllStaff();
    Staff getStaffById(Long id);
    Staff saveStaff(Staff staff);
    Staff updateStaff(Long id, Staff staff);
    void deleteStaff(Long id);

    List<Staff> findByRole(String role);
    List<Staff> findByDepartmentId(Long departmentId);
    List<Staff> searchByName(String name);
}
