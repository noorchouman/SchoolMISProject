package com.example.demo.service;

import com.example.demo.entities.Result;
import com.example.demo.repository.ResultRepository;
import com.example.demo.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
 
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
    public Result getResultById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }
    public Result updateResult(Long id, Result updatedResult) {
        Result existingResult = resultRepository.findById(id).orElse(null);
        if (existingResult != null) {
            existingResult.setScore(updatedResult.getScore());
            existingResult.setGradeLetter(updatedResult.getGradeLetter());
            existingResult.setStudent(updatedResult.getStudent());
            existingResult.setExam(updatedResult.getExam());
            return resultRepository.save(existingResult);
        }
        return null;
    }
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
    
    public List<Result> getResultsByStudentId(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }

    public List<Result> getResultsByExamId(Long examId) {
        return resultRepository.findByExamId(examId);
    }

    public List<Result> getResultsByMinScore(Double minScore) {
        return resultRepository.findByScoreGreaterThanEqual(minScore);
    }
    public List<Object[]> getAverageScoreGroupedByGradeLetter() {
        return resultRepository.findAverageScoreGroupedByGradeLetter();
    }
}
