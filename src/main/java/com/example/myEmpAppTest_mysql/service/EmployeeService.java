package com.example.myEmpAppTest_mysql.service;

import java.util.List;

import com.example.myEmpAppTest_mysql.model.Employee;

public interface EmployeeService {
	Employee findEmployee(int employeId);
	boolean deleteEmployee(int employeeId);
	boolean updateEmployee(Employee employee);
	boolean addEmployee(Employee employee);
	List<Employee> findAllEmployees();
	List<Employee> findAll_Sort(String sortBy, String sortDir);
}