package com.example.demo.controller;

import com.example.demo.Registration;
import com.example.demo.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {
        Registration registration = registrationService.getRegistrationById(id);
        if (registration != null) {
            return ResponseEntity.ok(registration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration) {
        Registration created = registrationService.saveRegistration(registration);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable Long id, @RequestBody Registration registration) {
        Registration updated = registrationService.updateRegistration(id, registration);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
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
}
