package com.example.demo.service;

import com.example.demo.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> existingTeacher = teacherRepository.findById(id);
        if (existingTeacher.isEmpty()) return null;
        Teacher t = existingTeacher.get();
        t.setName(teacher.getName());
        t.setAddress(teacher.getAddress());
        t.setSubject(teacher.getSubject());
        t.setSalary(teacher.getSalary());
        t.setRole(teacher.getRole());
        t.setDepartment(teacher.getDepartment());
        t.setHeadOf(teacher.getHeadOf());
        t.setMentorId(teacher.getMentorId());
        t.setRegistrations(teacher.getRegistrations());
        t.setCourses(teacher.getCourses());
        t.setExams(teacher.getExams());
        return teacherRepository.save(t);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public List<Teacher> findBySubject(String subject) {
        return teacherRepository.findBySubject(subject);
    }

    public List<Teacher> searchByName(String name) {
        return teacherRepository.findByNameContainingIgnoreCase(name);
    }
}
