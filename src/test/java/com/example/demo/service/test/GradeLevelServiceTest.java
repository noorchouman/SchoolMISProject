package com.example.demo.service.test;

import com.example.demo.entities.GradeLevel;
import com.example.demo.repository.GradeLevelRepository;
import com.example.demo.service.GradeLevelService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GradeLevelServiceTest {

    @Mock
    private GradeLevelRepository gradeLevelRepository;

    @InjectMocks
    private GradeLevelService gradeLevelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveGradeLevel_ShouldReturnSavedEntity() {
        GradeLevel gradeLevel = new GradeLevel();
        when(gradeLevelRepository.save(gradeLevel)).thenReturn(gradeLevel);

        GradeLevel result = gradeLevelService.saveGradeLevel(gradeLevel);

        assertEquals(gradeLevel, result);
        verify(gradeLevelRepository).save(gradeLevel);
    }

    @Test
    void getAllGradeLevels_ShouldReturnList() {
        List<GradeLevel> list = List.of(new GradeLevel(), new GradeLevel());
        when(gradeLevelRepository.findAll()).thenReturn(list);

        List<GradeLevel> result = gradeLevelService.getAllGradeLevels();

        assertEquals(list, result);
    }

    @Test
    void getGradeLevelById_ShouldReturnEntity_WhenExists() {
        GradeLevel gradeLevel = new GradeLevel();
        when(gradeLevelRepository.findById(1L)).thenReturn(Optional.of(gradeLevel));

        GradeLevel result = gradeLevelService.getGradeLevelById(1L);

        assertEquals(gradeLevel, result);
    }

    @Test
    void getGradeLevelById_ShouldReturnNull_WhenNotExists() {
        when(gradeLevelRepository.findById(1L)).thenReturn(Optional.empty());

        GradeLevel result = gradeLevelService.getGradeLevelById(1L);

        assertNull(result);
    }

    @Test
    void updateGradeLevel_ShouldUpdateAndReturnEntity_WhenExists() {
        GradeLevel existing = new GradeLevel();
        GradeLevel updated = new GradeLevel();
        updated.setName("Freshman");

        when(gradeLevelRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(gradeLevelRepository.save(existing)).thenReturn(existing);

        GradeLevel result = gradeLevelService.updateGradeLevel(1L, updated);

        assertEquals("Freshman", result.getName());
        verify(gradeLevelRepository).save(existing);
    }

    @Test
    void updateGradeLevel_ShouldReturnNull_WhenNotExists() {
        when(gradeLevelRepository.findById(1L)).thenReturn(Optional.empty());

        GradeLevel result = gradeLevelService.updateGradeLevel(1L, new GradeLevel());

        assertNull(result);
    }

    @Test
    void deleteGradeLevel_ShouldCallDeleteById() {
        gradeLevelService.deleteGradeLevel(1L);
        verify(gradeLevelRepository).deleteById(1L);
    }

    @Test
    void searchByName_ShouldReturnMatchingList() {
        List<GradeLevel> resultList = List.of(new GradeLevel());
        when(gradeLevelRepository.findByNameContainingIgnoreCase("senior")).thenReturn(resultList);

        List<GradeLevel> result = gradeLevelService.searchByName("senior");

        assertEquals(resultList, result);
    }
}
