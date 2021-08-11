package com.microservices.departments.controllers;

import com.microservices.departments.entities.Department;
import com.microservices.departments.services.DepartmentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department){
        log.info("addDepartment..."+department.toString());
        return departmentService.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id){
        //log.info("getDepartment by id=" + departmentId);
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/all")
    public List<Department> getAllDepartments(){
        log.info("getAllDepartments...");
        return departmentService.getAllDepartments();
    }
}
