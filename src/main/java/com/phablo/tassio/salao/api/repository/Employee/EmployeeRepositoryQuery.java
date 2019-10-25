package com.phablo.tassio.salao.api.repository.Employee;

import com.phablo.tassio.salao.api.model.Employee;
import com.phablo.tassio.salao.api.model.Filter.EmployeeFilter;
import com.phablo.tassio.salao.api.model.Filter.SimpleFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepositoryQuery {

    List<Employee> findAllWithFilter(EmployeeFilter employeeFilter, Pageable pageable);
}
