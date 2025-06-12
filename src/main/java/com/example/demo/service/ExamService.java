package com.example.demo.service;

import com.example.demo.entities.Exam;
import com.example.demo.repository.ExamRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Page<Exam> getAllExams(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return examRepository.findAll(pageable);
    }
    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElse(null);
    }

    public Exam updateExam(Long id, Exam updatedExam) {
        Optional<Exam> existingOpt = examRepository.findById(id);
        if (existingOpt.isPresent()) {
            Exam existing = existingOpt.get();
            existing.setCourseName(updatedExam.getCourseName());
            existing.setTeacher(updatedExam.getTeacher());
            existing.setCourse(updatedExam.getCourse());
            
            return examRepository.save(existing);
        }
        return null;
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
    public List<Exam> getExamsByCourseId(Long courseId) {
        return examRepository.findByCourseId(courseId);
    }
    public Page<Exam> getExamsAfterDate(LocalDateTime date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return examRepository.findByAuditCreatedDateAfter(date, pageable);
    }
    
}
