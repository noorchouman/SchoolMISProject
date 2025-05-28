package com.example.demo.controller;

import com.example.demo.Parent;
import com.example.demo.service.ParentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {
	
	@Autowired
    private ParentService parentService;


    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping("/{id}")
    public Parent getParentById(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

    @GetMapping("/phone/{phoneNumber}")
    public List<Parent> getByPhoneNumber(@PathVariable String phoneNumber) {
        return parentService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/search")
    public List<Parent> searchByName(@RequestParam String name) {
        return parentService.searchByName(name);
    }

    @PostMapping
    public Parent createParent(@RequestBody Parent parent) {
        return parentService.saveParent(parent);
    }

    @PutMapping("/{id}")
    public Parent updateParent(@PathVariable Long id, @RequestBody Parent parent) {
        return parentService.updateParent(id, parent);
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
    }
}
