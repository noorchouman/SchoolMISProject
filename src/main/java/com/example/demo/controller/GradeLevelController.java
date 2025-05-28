package com.example.demo.controller;

import com.example.demo.GradeLevel;
import com.example.demo.repository.GradeLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gradelevels")
public class GradeLevelController {

    @Autowired
    private GradeLevelRepository gradeLevelRepository;
    @GetMapping
    public List<GradeLevel> getAllGradeLevels() {
        return gradeLevelRepository.findAll();
    }
    @GetMapping("/{id}")
    public GradeLevel getGradeLevelById(@PathVariable Long id) {
        return gradeLevelRepository.findById(id).orElse(null);
    }
    @PostMapping
    public GradeLevel createGradeLevel(@RequestBody GradeLevel gradeLevel) {
        return gradeLevelRepository.save(gradeLevel);
    }
    @PutMapping("/{id}")
    public GradeLevel updateGradeLevel(@PathVariable Long id, @RequestBody GradeLevel updatedGradeLevel) {
        GradeLevel gradeLevel = gradeLevelRepository.findById(id).orElse(null);
        if (gradeLevel != null) {
            gradeLevel.setLevel(updatedGradeLevel.getLevel());
            gradeLevel.setName(updatedGradeLevel.getName());
            return gradeLevelRepository.save(gradeLevel);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteGradeLevel(@PathVariable Long id) {
        gradeLevelRepository.deleteById(id);
    }
}