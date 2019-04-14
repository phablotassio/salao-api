package com.phablo.tassio.salao.api.controller;

import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.PersonDTO;
import com.phablo.tassio.salao.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService pessoaService;

    public PersonController(PersonService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PersonDTO> cadastrarPessoa (@Valid @RequestBody PersonDTO personDTO) {
        return pessoaService.cadastrarPessoa(personDTO);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> buscarPessoaPorId(@PathVariable Long id) {
        return pessoaService.buscarporId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> atualizarPessoa(@PathVariable Long id, @RequestBody Person pessoa) {
        return pessoaService.atualizarPEssoa(id, pessoa);
    }

}
