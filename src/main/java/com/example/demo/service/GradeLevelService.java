package com.example.demo.service;

import com.example.demo.entities.GradeLevel;
import com.example.demo.repository.GradeLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeLevelService {

    private final GradeLevelRepository gradeLevelRepository;

    public GradeLevelService(GradeLevelRepository gradeLevelRepository) {
        this.gradeLevelRepository = gradeLevelRepository;
    }

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
        Optional<GradeLevel> existingOpt = gradeLevelRepository.findById(id);
        if (existingOpt.isPresent()) {
            GradeLevel existing = existingOpt.get();
            existing.setLevel(updatedGradeLevel.getLevel());
            existing.setName(updatedGradeLevel.getName());
            existing.setCourses(updatedGradeLevel.getCourses());
            existing.setStudents(updatedGradeLevel.getStudents());
            existing.setRegistrations(updatedGradeLevel.getRegistrations());
            return gradeLevelRepository.save(existing);
        }
        return null;
    }

    public void deleteGradeLevel(Long id) {
        gradeLevelRepository.deleteById(id);
    }
    public List<GradeLevel> searchByName(String namePart) {
        return gradeLevelRepository.findByNameContainingIgnoreCase(namePart);
    }

}
