package com.example.demo.controller;

import com.example.demo.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getById(@PathVariable Long id) {
        return teacherRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher updated) {
        return teacherRepository.findById(id).map(teacher -> {
            teacher.setName(updated.getName());
            teacher.setAddress(updated.getAddress());
            teacher.setRole(updated.getRole());
            teacher.setSalary(updated.getSalary());
            teacher.setMentorId(updated.getMentorId());
            teacher.setDepartment(updated.getDepartment());
            teacher.setSubject(updated.getSubject());
            return ResponseEntity.ok(teacherRepository.save(teacher));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }
}

