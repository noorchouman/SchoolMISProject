package com.example.demo.controller;
import com.example.demo.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;
    @GetMapping
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }
    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }
    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam updatedExam) {
        Exam exam = examRepository.findById(id).orElse(null);
        if (exam != null) {
            exam.setCourseName(updatedExam.getCourseName());
            exam.setCreatedAt(updatedExam.getCreatedAt());
            exam.setCreatedBy(updatedExam.getCreatedBy());
            exam.setDepartment(updatedExam.getDepartment());
            return examRepository.save(exam);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examRepository.deleteById(id);
    }
}
