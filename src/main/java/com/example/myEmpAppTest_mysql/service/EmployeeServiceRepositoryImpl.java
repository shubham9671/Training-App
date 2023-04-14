package com.example.myEmpAppTest_mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myEmpAppTest_mysql.model.Employee;
import com.example.myEmpAppTest_mysql.repository.EmployeeRepository;

import org.springframework.data.domain.Sort;

@Service("employeeServiceRepositoryImpl")
public class EmployeeServiceRepositoryImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee findEmployee(int employeId) {
		// TODO Auto-generated method stub
		return repository.findById(employeId).get();
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Employee employee = repository.findById(employeeId).get();
		if (employee != null) {
			repository.delete(employee);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Employee employee1 = repository.findById(employee.getEmployeeId()).get();
		if (employee1 != null) {
			return repository.save(employee) == employee;
		}
		return false;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return repository.save(employee) == employee;
	}

	@Override
	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}

	@Override
	public List<Employee> findAll_Sort(String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
				Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		return repository.findAll(sort);
	}

}