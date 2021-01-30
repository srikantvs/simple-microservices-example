package com.srikantvs.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srikantvs.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findByDepartmentId(Long departmentid);
}
