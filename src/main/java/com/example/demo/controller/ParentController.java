package com.example.demo.controller;

import com.example.demo.Parent;
import com.example.demo.service.ParentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
        Parent parent = parentService.getParentById(id);
        if (parent != null) {
            return ResponseEntity.ok(parent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent created = parentService.saveParent(parent);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable Long id, @RequestBody Parent parent) {
        Parent updated = parentService.updateParent(id, parent);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/phone/{phoneNumber}")
    public List<Parent> getByPhoneNumber(@PathVariable String phoneNumber) {
        return parentService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/search")
    public List<Parent> searchByName(@RequestParam String name) {
        return parentService.searchByName(name);
    }
}
