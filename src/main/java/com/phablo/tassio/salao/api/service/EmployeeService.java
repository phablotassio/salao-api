package com.phablo.tassio.salao.api.service;

import com.phablo.tassio.salao.api.model.Employee;
import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.EmployeeRequestDTO;
import com.phablo.tassio.salao.api.model.dto.EmployeeResponseDTO;
import com.phablo.tassio.salao.api.mapper.EmployeeMapper;
import com.phablo.tassio.salao.api.repository.EmployeeRepository;
import com.phablo.tassio.salao.api.model.Filter.EmployeeFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JuridicalPersonService juridicalPersonService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeMapper personMapper;

    public ResponseEntity<EmployeeResponseDTO> cadastrarPessoa(EmployeeRequestDTO employeeRequestDTO){

        Employee employeeSaved = employeeRepository.save(resolveEmployee(employeeRequestDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(employeeSaved.getId()).toUri();

        return ResponseEntity.created(uri).body(personMapper.employeeToEmployeeResponseDto(employeeSaved));
    }

    public ResponseEntity<List<EmployeeResponseDTO>> listarPessoas(EmployeeFilter employeeFilter, Pageable pageable) {
        return ResponseEntity.ok(employeeRepository.findAllWithFilter(employeeFilter, pageable).stream().map(person -> personMapper.employeeToEmployeeResponseDto(person)).collect(Collectors.toList()));
    }


    public void excluirPessoa(Long id) {

        employeeRepository.deleteById(id);
    }

    public ResponseEntity<EmployeeResponseDTO> atualizarPEssoa(Long id, Person pessoa) {

        Employee employeeSaved = getPessoaPorId(id);
        BeanUtils.copyProperties(pessoa,employeeSaved, "id");

        return ResponseEntity.ok(personMapper.employeeToEmployeeResponseDto(employeeRepository.save(employeeSaved)));
    }

    public ResponseEntity<EmployeeResponseDTO> buscarporId(Long id) {

        return ResponseEntity.ok(personMapper.employeeToEmployeeResponseDto(getPessoaPorId(id)));
    }

    private Employee getPessoaPorId(Long id) {

      return employeeRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("A pessoa procurada não está cadastrada.", 1));

    }

    private Employee resolveEmployee(EmployeeRequestDTO employeeRequestDTO) {

        Employee employee = personMapper.employeeRequestDTOToEmployee(employeeRequestDTO);
        employee.setJuridicalPerson(juridicalPersonService.findById(employeeRequestDTO.getIdJuridicalPerson()));
        employee.setRole(roleService.findById(employeeRequestDTO.getIdRole()));

        return employee;
    }


}
