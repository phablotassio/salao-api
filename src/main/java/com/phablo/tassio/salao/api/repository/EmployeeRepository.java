package com.phablo.tassio.salao.api.repository;

import com.phablo.tassio.salao.api.model.Employee;
import com.phablo.tassio.salao.api.repository.Employee.EmployeeRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryQuery {

}
