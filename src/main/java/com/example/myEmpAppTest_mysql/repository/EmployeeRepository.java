package com.example.myEmpAppTest_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.myEmpAppTest_mysql.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends  JpaRepository<Employee, Integer> {

}
