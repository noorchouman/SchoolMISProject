package com.example.demo.service.test;

import com.example.demo.entities.Result;
import com.example.demo.repository.ResultRepository;
import com.example.demo.service.ResultService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ResultServiceTest {

    @Mock
    private ResultRepository resultRepository;

    @InjectMocks
    private ResultService resultService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveResult_ShouldReturnSavedResult() {
        Result result = new Result();
        when(resultRepository.save(result)).thenReturn(result);

        Result saved = resultService.saveResult(result);

        assertEquals(result, saved);
        verify(resultRepository).save(result);
    }

    @Test
    void getAllResults_ShouldReturnList() {
        List<Result> results = List.of(new Result(), new Result());
        when(resultRepository.findAll()).thenReturn(results);

        List<Result> fetched = resultService.getAllResults();

        assertEquals(results, fetched);
    }

    @Test
    void getResultById_ShouldReturnResult_WhenExists() {
        Result result = new Result();
        when(resultRepository.findById(1L)).thenReturn(Optional.of(result));

        Result fetched = resultService.getResultById(1L);

        assertEquals(result, fetched);
    }

    @Test
    void getResultById_ShouldReturnNull_WhenNotExists() {
        when(resultRepository.findById(1L)).thenReturn(Optional.empty());

        Result fetched = resultService.getResultById(1L);

        assertNull(fetched);
    }

    @Test
    void updateResult_ShouldUpdateAndReturn_WhenExists() {
        Result existing = new Result();
        Result updated = new Result();
        updated.setScore(95.0);
        updated.setGradeLetter("A");

        when(resultRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(resultRepository.save(existing)).thenReturn(existing);

        Result result = resultService.updateResult(1L, updated);

        assertEquals(95.0, result.getScore());
        assertEquals("A", result.getGradeLetter());
    }

    @Test
    void updateResult_ShouldReturnNull_WhenNotExists() {
        when(resultRepository.findById(1L)).thenReturn(Optional.empty());

        Result result = resultService.updateResult(1L, new Result());

        assertNull(result);
    }

    @Test
    void deleteResult_ShouldCallDeleteById() {
        resultService.deleteResult(1L);
        verify(resultRepository).deleteById(1L);
    }

    @Test
    void getResultsByStudentId_ShouldReturnList() {
        List<Result> results = List.of(new Result());
        when(resultRepository.findByStudentId(10L)).thenReturn(results);

        List<Result> fetched = resultService.getResultsByStudentId(10L);

        assertEquals(results, fetched);
    }

    @Test
    void getResultsByExamId_ShouldReturnList() {
        List<Result> results = List.of(new Result());
        when(resultRepository.findByExamId(5L)).thenReturn(results);

        List<Result> fetched = resultService.getResultsByExamId(5L);

        assertEquals(results, fetched);
    }

    @Test
    void getResultsByMinScore_ShouldReturnMatchingResults() {
        List<Result> results = List.of(new Result());
        when(resultRepository.findByScoreGreaterThanEqual(80.0)).thenReturn(results);

        List<Result> fetched = resultService.getResultsByMinScore(80.0);

        assertEquals(results, fetched);
    }

    @Test
    void getAverageScoreGroupedByGradeLetter_ShouldReturnAggregatedData() {
        List<Object[]> avgData = List.of(new Object[]{"A", 90.0}, new Object[]{"B", 80.0});
        when(resultRepository.findAverageScoreGroupedByGradeLetter()).thenReturn(avgData);

        List<Object[]> result = resultService.getAverageScoreGroupedByGradeLetter();

        assertEquals(avgData, result);
    }
}
