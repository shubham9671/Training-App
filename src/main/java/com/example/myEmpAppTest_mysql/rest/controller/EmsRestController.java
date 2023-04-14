package com.example.myEmpAppTest_mysql.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myEmpAppTest_mysql.model.Employee;
import com.example.myEmpAppTest_mysql.service.EmployeeService;

@CrossOrigin
@RequestMapping("/employees")
@RestController
public class EmsRestController {

	@Autowired
	private EmployeeService employeeService;

	public EmsRestController() {
		System.out.println("######### EmsRestController created########");
	}
	
	// http://localhost:8080/springboot-ems-app/employees
	@GetMapping
	public List<Employee> getAllEmployees() {
	return employeeService.findAllEmployees();
	}
		
	// http://localhost:8080/springboot-ems-app/employees/101
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id")int id) {
	return employeeService.findEmployee(id);
	}
	
	@DeleteMapping("/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id")int id) {
		   employeeService.deleteEmployee(id);
		return employeeService.findAllEmployees();	
	}
	/*
	 {"employeeId":93568,
   "fname":"Ashwin123",
   "lname":"Sharma",
   "salary":23000,
   "email":"sharma@gmail.com",
   "doj":"2022-02-23",
   "mobile":9805666,
   "pan":"AwX9877"
}
 */
	
	@PutMapping("/{id}")
	public List<Employee> updateEmployee(@PathVariable("id")int id,
			@RequestBody Employee employee) {
		  employeeService.updateEmployee(employee);
		  return employeeService.findAllEmployees();
	}
	/*{
   "fname":"Ashwin",
   "lname":"Sharma",
   "salary":23000,
   "email":"sharma@gmail.com",
   "doj":"2022-02-23",
   "mobile":9805666,
   "pan":"AwX9877"
}
*/
	@PostMapping
	public List<Employee> addEmployee(@RequestBody Employee employee) {
		  employeeService.addEmployee(employee);
		  return employeeService.findAllEmployees();
	
	}	
	
	@GetMapping("/{sortBy}/{sortDir}")
	public List<Employee> findAll_Sort(@PathVariable("sortBy") String sortBy,
			@PathVariable("sortDir")  String sortDir) {
		return employeeService.findAll_Sort(sortBy, sortDir);
	}
}
