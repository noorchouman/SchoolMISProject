package com.example.demo.service;

import com.example.demo.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> dept = departmentRepository.findById(id);
        return dept.orElse(null);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department department) {
        if (!departmentRepository.existsById(id)) {
            return null;
        }
        department.setId(id);
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }
}
