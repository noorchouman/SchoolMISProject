package com.example.demo.service;

import com.example.demo.Staff;
import com.example.demo.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        Optional<Staff> staff = staffRepository.findById(id);
        return staff.orElse(null);
    }

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff staff) {
        Optional<Staff> existingStaff = staffRepository.findById(id);
        if (existingStaff.isEmpty()) return null;
        Staff s = existingStaff.get();
        s.setName(staff.getName());
        s.setAddress(staff.getAddress());
        s.setRole(staff.getRole());
        s.setSalary(staff.getSalary());
        s.setMentorId(staff.getMentorId());
        s.setDepartment(staff.getDepartment());
        s.setHeadOf(staff.getHeadOf());
        s.setRegistrations(staff.getRegistrations());
        return staffRepository.save(s);
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    public List<Staff> findByRole(String role) {
        return staffRepository.findByRole(role);
    }

    public List<Staff> findByDepartmentId(Long departmentId) {
        // department is an object, use underscore for JPA
        return staffRepository.findByDepartmentId(departmentId);
    }

    public List<Staff> searchByName(String name) {
        return staffRepository.findByNameContainingIgnoreCase(name);
    }
}
