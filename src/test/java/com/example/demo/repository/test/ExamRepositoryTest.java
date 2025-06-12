package com.example.demo.repository.test;

import com.example.demo.entities.Course;
import com.example.demo.entities.Exam;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.ExamRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ExamRepositoryTest {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private CourseRepository courseRepository;  

    @Test
    void testSaveAndFindByCourseId() {
      
        Course course = new Course();
        course.setCourseName("Math");
        course = courseRepository.save(course); 

        Exam exam = new Exam();
        exam.setCourse(course);
        exam.setCourseName("Math"); 
        Exam saved = examRepository.save(exam);

        
        List<Exam> found = examRepository.findByCourseId(course.getId());

       
        assertThat(found).contains(saved);
    }
}
