package com.example.demo.controller;

import com.example.demo.GradeLevel;
import com.example.demo.service.GradeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gradelevels")
public class GradeLevelController {

    @Autowired
    private GradeLevelService gradeLevelService;

    @GetMapping
    public List<GradeLevel> getAllGradeLevels() {
        return gradeLevelService.getAllGradeLevels();
    }
    @GetMapping("/{id}")
    public GradeLevel getGradeLevelById(@PathVariable Long id) {
        return gradeLevelService.getGradeLevelById(id);
    }
    @PostMapping
    public GradeLevel createGradeLevel(@RequestBody GradeLevel gradeLevel) {
        return gradeLevelService.saveGradeLevel(gradeLevel);
    }
    @PutMapping("/{id}")
    public GradeLevel updateGradeLevel(@PathVariable Long id, @RequestBody GradeLevel gradeLevel) {
        return gradeLevelService.updateGradeLevel(id, gradeLevel);
    }
    @DeleteMapping("/{id}")
    public void deleteGradeLevel(@PathVariable Long id) {
        gradeLevelService.deleteGradeLevel(id);
    }
}
