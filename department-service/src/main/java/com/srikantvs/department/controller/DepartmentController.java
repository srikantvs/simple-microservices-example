package com.srikantvs.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srikantvs.department.entity.Department;
import com.srikantvs.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// method to save dept
	@PostMapping(value = "/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	// method to get dept based on id;

	@GetMapping(value = "/{id}")
	public Department findByDepartmentId(@PathVariable("id") Long departmentId) {
		log.info("inside findDepartmentById of DepartmentController");
		return departmentService.findByDepartmentId(departmentId);
	}

}
