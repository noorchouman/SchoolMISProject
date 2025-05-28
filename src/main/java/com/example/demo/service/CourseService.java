package com.example.demo.service;

import com.example.demo.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Optional<Course> existingOpt = courseRepository.findById(id);
        if (existingOpt.isPresent()) {
            Course existing = existingOpt.get();
            existing.setCourseName(updatedCourse.getCourseName());
            existing.setCreatedAt(updatedCourse.getCreatedAt());
            existing.setCreatedBy(updatedCourse.getCreatedBy());
            existing.setLastModifiedAt(updatedCourse.getLastModifiedAt());
            existing.setLastModifiedBy(updatedCourse.getLastModifiedBy());
            existing.setTeacher(updatedCourse.getTeacher());
            existing.setGradeLevel(updatedCourse.getGradeLevel());
            // You can also update exams if needed
            return courseRepository.save(existing);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
