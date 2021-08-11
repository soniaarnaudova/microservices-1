package com.microservices.departments.services;

import com.microservices.departments.entities.Department;
import com.microservices.departments.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) {

        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }
}

