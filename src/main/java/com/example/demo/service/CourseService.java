package com.example.demo.service;

import com.example.demo.entities.Course;
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
            existing.setTeacher(updatedCourse.getTeacher());
            existing.setGradeLevel(updatedCourse.getGradeLevel());
           
            return courseRepository.save(existing);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    
    public List<Course> getCoursesByTeacherId(Long teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }

    public List<Course> getCoursesByGradeLevelId(Long gradeLevelId) {
        return courseRepository.findByGradeLevelId(gradeLevelId);
    }

    public List<Course> searchByCourseName(String courseName) {
        return courseRepository.findByCourseNameContainingIgnoreCase(courseName);
    }
}
