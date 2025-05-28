package com.example.demo.service;

import com.example.demo.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElse(null);
    }

    public Exam updateExam(Long id, Exam updatedExam) {
        Optional<Exam> existingOpt = examRepository.findById(id);
        if (existingOpt.isPresent()) {
            Exam existing = existingOpt.get();
            existing.setCourseName(updatedExam.getCourseName());
            existing.setCreatedAt(updatedExam.getCreatedAt());
            existing.setCreatedBy(updatedExam.getCreatedBy());
            
            existing.setTeacher(updatedExam.getTeacher());
            existing.setCourse(updatedExam.getCourse());
            
            return examRepository.save(existing);
        }
        return null;
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
