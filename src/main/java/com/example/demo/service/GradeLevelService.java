package com.example.demo.service;

import com.example.demo.GradeLevel;
import com.example.demo.repository.GradeLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeLevelService {

    @Autowired
    private GradeLevelRepository gradeLevelRepository;

    public GradeLevel saveGradeLevel(GradeLevel gradeLevel) {
        return gradeLevelRepository.save(gradeLevel);
    }
    public List<GradeLevel> getAllGradeLevels() {
        return gradeLevelRepository.findAll();
    }
    public GradeLevel getGradeLevelById(Long id) {
        return gradeLevelRepository.findById(id).orElse(null);
    }
    public GradeLevel updateGradeLevel(Long id, GradeLevel updatedGradeLevel) {
        GradeLevel existing = gradeLevelRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setLevel(updatedGradeLevel.getLevel());
            existing.setName(updatedGradeLevel.getName());
            return gradeLevelRepository.save(existing);
        }
        return null;
    }
    public void deleteGradeLevel(Long id) {
        gradeLevelRepository.deleteById(id);
    }
}

