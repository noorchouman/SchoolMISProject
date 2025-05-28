package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Course;
import com.example.demo.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
@Autowired 
private CourseRepository courseRepository;
@PostMapping 
public Course createCourse(@RequestBody Course course) {
	return courseRepository.save(course);}
@GetMapping 
public List<Course> getAllCourses(){
	return courseRepository.findAll();
}
@GetMapping("/{id}")
public Course getCourseById(@PathVariable Long id) {
	return courseRepository.findById(id).orElse(null);
}
@PutMapping("/{id}")
public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
	Course course = courseRepository.findById(id).orElse(null);
    if (course != null) {
    	 course.setCourseName(updatedCourse.getCourseName());
         course.setCreatedAt(updatedCourse.getCreatedAt());
         course.setCreatedBy(updatedCourse.getCreatedBy());
         course.setLastModifiedAt(updatedCourse.getLastModifiedAt());
         course.setLastModifiedBy(updatedCourse.getLastModifiedBy());
         course.setDepartment(updatedCourse.getDepartment());

    return courseRepository.save(course);}
 else {
    return null;
}
}
@DeleteMapping("/{id}")
public void deleteCourse(@PathVariable Long id) {
    courseRepository.deleteById(id);}
}
