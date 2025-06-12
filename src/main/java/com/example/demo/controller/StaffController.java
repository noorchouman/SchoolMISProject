package com.example.demo.controller;

import com.example.demo.entities.Staff;
import com.example.demo.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
    private StaffService staffService;


    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @GetMapping("/role/{role}")
    public List<Staff> getByRole(@PathVariable String role) {
        return staffService.findByRole(role);
    }

    @GetMapping("/department/{departmentId}")
    public List<Staff> getByDepartment(@PathVariable Long departmentId) {
        return staffService.findByDepartmentId(departmentId);
    }

    @GetMapping("/search")
    public List<Staff> searchByName(@RequestParam String name) {
        return staffService.searchByName(name);
    }

    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        return staffService.updateStaff(id, staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }
}
