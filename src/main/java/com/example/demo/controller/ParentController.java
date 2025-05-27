package com.example.demo.controller;

import com.example.demo.Parent;
import com.example.demo.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private ParentRepository parentRepository;

    @GetMapping
    public List<Parent> getAll() {
        return parentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getById(@PathVariable Long id) {
        return parentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Parent create(@RequestBody Parent parent) {
        return parentRepository.save(parent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> update(@PathVariable Long id, @RequestBody Parent updated) {
        return parentRepository.findById(id).map(parent -> {
            parent.setName(updated.getName());
            parent.setAddress(updated.getAddress());
            parent.setPhoneNumber(updated.getPhoneNumber());
            parent.setChildren(updated.getChildren());
            return ResponseEntity.ok(parentRepository.save(parent));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        parentRepository.deleteById(id);
    }
}
