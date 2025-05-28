package com.example.demo.service;

import com.example.demo.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

   
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
        Exam existing = examRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCourseName(updatedExam.getCourseName());
            existing.setCreatedAt(updatedExam.getCreatedAt());
            existing.setCreatedBy(updatedExam.getCreatedBy());
            existing.setDepartment(updatedExam.getDepartment());
            return examRepository.save(existing);
        }
        return null;
    }
    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
