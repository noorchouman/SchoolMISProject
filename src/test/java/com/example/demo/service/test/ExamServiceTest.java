package com.example.demo.service.test;

import com.example.demo.entities.Exam;
import com.example.demo.repository.ExamRepository;
import com.example.demo.service.ExamService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ExamServiceTest {

    @Mock
    private ExamRepository examRepository;

    @InjectMocks
    private ExamService examService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveExam() {
        Exam exam = new Exam();
        exam.setCourseName("Physics");

        when(examRepository.save(exam)).thenReturn(exam);

        Exam saved = examService.saveExam(exam);

        assertThat(saved).isEqualTo(exam);
        verify(examRepository).save(exam);
    }

    @Test
    void testGetAllExams() {
        Exam exam1 = new Exam();
        exam1.setCourseName("Math");
        Exam exam2 = new Exam();
        exam2.setCourseName("Chemistry");

        List<Exam> examList = Arrays.asList(exam1, exam2);
        Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Exam> page = new PageImpl<>(examList, pageable, examList.size());

        when(examRepository.findAll(pageable)).thenReturn(page);

        Page<Exam> result = examService.getAllExams(0, 2);

        assertThat(result.getContent()).hasSize(2).contains(exam1, exam2);
        verify(examRepository).findAll(pageable);
    }

    @Test
    void testGetExamByIdFound() {
        Exam exam = new Exam();
        exam.setId(1L);
        when(examRepository.findById(1L)).thenReturn(Optional.of(exam));

        Exam found = examService.getExamById(1L);

        assertThat(found).isEqualTo(exam);
        verify(examRepository).findById(1L);
    }

    @Test
    void testGetExamByIdNotFound() {
        when(examRepository.findById(1L)).thenReturn(Optional.empty());

        Exam found = examService.getExamById(1L);

        assertThat(found).isNull();
        verify(examRepository).findById(1L);
    }

    @Test
    void testUpdateExamFound() {
        Exam existing = new Exam();
        existing.setId(1L);
        existing.setCourseName("Old Name");

        Exam updated = new Exam();
        updated.setCourseName("New Name");
      
        when(examRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(examRepository.save(any(Exam.class))).thenAnswer(i -> i.getArgument(0));

        Exam result = examService.updateExam(1L, updated);

        assertThat(result.getCourseName()).isEqualTo("New Name");
        verify(examRepository).findById(1L);
        verify(examRepository).save(existing);
    }

    @Test
    void testUpdateExamNotFound() {
        Exam updated = new Exam();
        when(examRepository.findById(1L)).thenReturn(Optional.empty());

        Exam result = examService.updateExam(1L, updated);

        assertThat(result).isNull();
        verify(examRepository).findById(1L);
        verify(examRepository, never()).save(any());
    }

    @Test
    void testDeleteExam() {
        doNothing().when(examRepository).deleteById(1L);

        examService.deleteExam(1L);

        verify(examRepository).deleteById(1L);
    }

    @Test
    void testGetExamsByCourseId() {
        List<Exam> exams = Collections.singletonList(new Exam());
        when(examRepository.findByCourseId(10L)).thenReturn(exams);

        List<Exam> result = examService.getExamsByCourseId(10L);

        assertThat(result).isEqualTo(exams);
        verify(examRepository).findByCourseId(10L);
    }

    @Test
    void testGetExamsAfterDate() {
        LocalDateTime date = LocalDateTime.now().minusDays(1);
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "createdAt"));
        List<Exam> exams = Collections.singletonList(new Exam());
        Page<Exam> page = new PageImpl<>(exams, pageable, 1);

        when(examRepository.findByAuditCreatedDateAfter(date, pageable)).thenReturn(page);

        Page<Exam> result = examService.getExamsAfterDate(date, 0, 5);

        assertThat(result.getContent()).isEqualTo(exams);
        verify(examRepository).findByAuditCreatedDateAfter(date, pageable);
    }
}
