package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isEmpty()) return null;
        Student s = existingStudent.get();
        s.setName(student.getName());
        s.setAddress(student.getAddress());
        s.setClassroomId(student.getClassroomId());
        s.setGradeLevel(student.getGradeLevel());
        s.setParents(student.getParents());
        s.setClubs(student.getClubs());
        s.setResults(student.getResults());
        s.setRegistrations(student.getRegistrations());
        return studentRepository.save(s);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByClassroomId(String classroomId) {
        return studentRepository.findByClassroomId(classroomId);
    }

    public List<Student> findByGradeLevelId(Long gradeLevelId) {
        // gradeLevel is an object, use underscore for JPA
        return studentRepository.findByGradeLevelId(gradeLevelId);
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    
}
