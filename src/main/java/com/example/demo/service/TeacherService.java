package com.example.demo.service;

import com.example.demo.Teacher;
import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    Teacher saveTeacher(Teacher teacher);
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);

    List<Teacher> findBySubject(String subject);
    List<Teacher> searchByName(String name);
}
