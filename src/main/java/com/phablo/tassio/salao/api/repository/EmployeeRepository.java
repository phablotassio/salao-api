package com.phablo.tassio.salao.api.repository;

import com.phablo.tassio.salao.api.model.Employee;
import com.phablo.tassio.salao.api.model.FisicPerson;
import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.repository.Employee.EmployeeRepositoryQuerry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long >, EmployeeRepositoryQuerry {

}
