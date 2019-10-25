package com.phablo.tassio.salao.api.controller;

import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.EmployeeRequestDTO;
import com.phablo.tassio.salao.api.model.dto.EmployeeResponseDTO;
import com.phablo.tassio.salao.api.model.Filter.EmployeeFilter;
import com.phablo.tassio.salao.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private EmployeeService pessoaService;

    public PersonController(EmployeeService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> cadastrarPessoa(@Valid @RequestBody EmployeeRequestDTO personDTO) {
        return pessoaService.cadastrarPessoa(personDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> listarPessoas(EmployeeFilter employeeFilter, Pageable pageable) {
        return pessoaService.listarPessoas(employeeFilter, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> buscarPessoaPorId(@PathVariable Long id) {
        return pessoaService.buscarporId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> atualizarPessoa(@PathVariable Long id, @RequestBody Person pessoa) {
        return pessoaService.atualizarPEssoa(id, pessoa);
    }

}
