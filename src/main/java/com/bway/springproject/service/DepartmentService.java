package com.bway.springproject.service;

import java.util.List;

import com.bway.springproject.model.Department;

public interface DepartmentService {
	
	void addDept(Department  dept);
	
	List<Department> getDepartments();

	Department getDeptById(int id);
}
