package com.example.demo.controller;

import com.example.demo.entities.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
    @GetMapping("/teacher/{teacherId}")
    public List<Course> getCoursesByTeacher(@PathVariable Long teacherId) {
        return courseService.getCoursesByTeacherId(teacherId);
    }

    @GetMapping("/gradeLevel/{gradeLevelId}")
    public List<Course> getCoursesByGradeLevel(@PathVariable Long gradeLevelId) {
        return courseService.getCoursesByGradeLevelId(gradeLevelId);
    }

    @GetMapping("/search")
    public List<Course> searchCourses(@RequestParam String name) {
        return courseService.searchByCourseName(name);
    }

}
