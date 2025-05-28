package com.example.demo.controller;

import com.example.demo.Registration;
import com.example.demo.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
	
	@Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistrationById(@PathVariable Long id) {
        return registrationService.getRegistrationById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Registration> getByStudentId(@PathVariable Long studentId) {
        return registrationService.findByStudentId(studentId);
    }

    @GetMapping("/parent/{parentId}")
    public List<Registration> getByParentId(@PathVariable Long parentId) {
        return registrationService.findByParentId(parentId);
    }

    @GetMapping("/staff/{staffId}")
    public List<Registration> getByStaffId(@PathVariable Long staffId) {
        return registrationService.findByStaffId(staffId);
    }

    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationService.saveRegistration(registration);
    }

    @PutMapping("/{id}")
    public Registration updateRegistration(@PathVariable Long id, @RequestBody Registration registration) {
        return registrationService.updateRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
    }
}
