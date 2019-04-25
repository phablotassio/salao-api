package com.phablo.tassio.salao.api.repository.Employee;

import com.phablo.tassio.salao.api.model.Employee;
import com.phablo.tassio.salao.api.model.Filter.EmployeeFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepositoryQuerry {

    public List<Employee> findAllWithFilter(EmployeeFilter employeeFilter, Pageable pageable);

}
