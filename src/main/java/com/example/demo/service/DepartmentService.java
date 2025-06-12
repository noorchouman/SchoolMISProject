package com.example.demo.service;

import com.example.demo.entities.Department;
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
        Optional<Department> deptOpt = departmentRepository.findById(id);
        if (deptOpt.isEmpty()) return null;
        Department dept = deptOpt.get();
        dept.setName(department.getName());
        dept.setStaffs(department.getStaffs());
        dept.setHead(department.getHead());
        return departmentRepository.save(dept);
    }


    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }
}
