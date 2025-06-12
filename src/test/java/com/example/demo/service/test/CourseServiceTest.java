package com.example.demo.service.test;

import com.example.demo.entities.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCourse_ShouldReturnSavedCourse() {
        Course course = new Course();
        when(courseRepository.save(course)).thenReturn(course);

        Course result = courseService.saveCourse(course);

        assertEquals(course, result);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void getAllCourses_ShouldReturnList() {
        List<Course> courseList = List.of(new Course(), new Course());
        when(courseRepository.findAll()).thenReturn(courseList);

        List<Course> result = courseService.getAllCourses();

        assertEquals(courseList, result);
    }

    @Test
    void getCourseById_ShouldReturnCourse_WhenExists() {
        Course course = new Course();
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        Course result = courseService.getCourseById(1L);

        assertEquals(course, result);
    }

    @Test
    void getCourseById_ShouldReturnNull_WhenNotExists() {
        when(courseRepository.findById(1L)).thenReturn(Optional.empty());

        Course result = courseService.getCourseById(1L);

        assertNull(result);
    }

    @Test
    void updateCourse_ShouldUpdateAndReturnCourse_WhenExists() {
        Course existing = new Course();
        Course updated = new Course();
        updated.setCourseName("Math");
        when(courseRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(courseRepository.save(any())).thenReturn(existing);

        Course result = courseService.updateCourse(1L, updated);

        assertEquals("Math", result.getCourseName());
        verify(courseRepository).save(existing);
    }

    @Test
    void updateCourse_ShouldReturnNull_WhenNotExists() {
        when(courseRepository.findById(1L)).thenReturn(Optional.empty());

        Course result = courseService.updateCourse(1L, new Course());

        assertNull(result);
    }

    @Test
    void deleteCourse_ShouldCallDelete() {
        courseService.deleteCourse(1L);
        verify(courseRepository).deleteById(1L);
    }

    @Test
    void getCoursesByTeacherId_ShouldReturnList() {
        List<Course> courses = List.of(new Course());
        when(courseRepository.findByTeacherId(2L)).thenReturn(courses);

        List<Course> result = courseService.getCoursesByTeacherId(2L);

        assertEquals(courses, result);
    }

    @Test
    void getCoursesByGradeLevelId_ShouldReturnList() {
        List<Course> courses = List.of(new Course());
        when(courseRepository.findByGradeLevelId(3L)).thenReturn(courses);

        List<Course> result = courseService.getCoursesByGradeLevelId(3L);

        assertEquals(courses, result);
    }

    @Test
    void searchByCourseName_ShouldReturnList() {
        List<Course> courses = List.of(new Course());
        when(courseRepository.findByCourseNameContainingIgnoreCase("bio")).thenReturn(courses);

        List<Course> result = courseService.searchByCourseName("bio");

        assertEquals(courses, result);
    }
}
