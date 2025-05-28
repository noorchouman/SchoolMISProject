package com.example.demo.service;

import com.example.demo.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

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
        Course existing = courseRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCourseName(updatedCourse.getCourseName());
            existing.setCreatedAt(updatedCourse.getCreatedAt());
            existing.setCreatedBy(updatedCourse.getCreatedBy());
            existing.setLastModifiedAt(updatedCourse.getLastModifiedAt());
            existing.setLastModifiedBy(updatedCourse.getLastModifiedBy());
            existing.setDepartment(updatedCourse.getDepartment());
            return courseRepository.save(existing);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

