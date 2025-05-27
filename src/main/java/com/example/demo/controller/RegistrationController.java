package com.example.demo.controller;

import com.example.demo.Registration;
import com.example.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @GetMapping
    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getById(@PathVariable Long id) {
        return registrationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        return registrationRepository.save(registration);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> update(@PathVariable Long id, @RequestBody Registration updated) {
        return registrationRepository.findById(id).map(registration -> {
            registration.setStudent(updated.getStudent());
            registration.setParent(updated.getParent());
            registration.setStaff(updated.getStaff());
            registration.setGradeLevel(updated.getGradeLevel());
            return ResponseEntity.ok(registrationRepository.save(registration));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        registrationRepository.deleteById(id);
    }
}
