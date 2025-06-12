package com.example.demo.controller;

import com.example.demo.entities.Result;
import com.example.demo.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @GetMapping("/{id}")
    public Result getResultById(@PathVariable Long id) {
        return resultService.getResultById(id);
    }

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @PutMapping("/{id}")
    public Result updateResult(@PathVariable Long id, @RequestBody Result updatedResult) {
        return resultService.updateResult(id, updatedResult);
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
    }
    
    @GetMapping("/student/{studentId}")
    public List<Result> getResultsByStudent(@PathVariable Long studentId) {
        return resultService.getResultsByStudentId(studentId);
    }

    @GetMapping("/exam/{examId}")
    public List<Result> getResultsByExam(@PathVariable Long examId) {
        return resultService.getResultsByExamId(examId);
    }

    @GetMapping("/min-score")
    public List<Result> getResultsByMinScore(@RequestParam Double score) {
        return resultService.getResultsByMinScore(score);
    }
    @GetMapping("/average-by-grade")
    public List<Object[]> getAverageScoreByGrade() {
        return resultService.getAverageScoreGroupedByGradeLetter();
    }
}
