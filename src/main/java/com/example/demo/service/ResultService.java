package com.example.demo.service;

import com.example.demo.Result;
import com.example.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

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
}
