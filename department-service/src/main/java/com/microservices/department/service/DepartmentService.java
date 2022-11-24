package com.microservices.department.service;


import com.microservices.department.entity.Department;

public interface DepartmentService {


    public Department saveDepartment(Department department) ;

    Department findDepartmentById(Long departmentId);
}
