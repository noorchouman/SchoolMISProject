package com.example.demo.controller;

import com.example.demo.Result;
import com.example.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;
    @GetMapping
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
    @GetMapping("/{id}")
    public Result getResultById(@PathVariable Long id) {
        return resultRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultRepository.save(result);
    }
    @PutMapping("/{id}")
    public Result updateResult(@PathVariable Long id, @RequestBody Result updatedResult) {
        Result result = resultRepository.findById(id).orElse(null);
        if (result != null) {
            result.setScore(updatedResult.getScore());
            result.setGradeLetter(updatedResult.getGradeLetter());
            result.setStudent(updatedResult.getStudent());
            result.setExam(updatedResult.getExam());
            return resultRepository.save(result);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        resultRepository.deleteById(id);
    }
}