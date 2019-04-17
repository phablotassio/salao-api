package com.phablo.tassio.salao.api.controller;

import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.FisicPersonDTO;
import com.phablo.tassio.salao.api.service.FisicPersonService;
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
    private FisicPersonService pessoaService;

    public PersonController(FisicPersonService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<FisicPersonDTO> cadastrarPessoa (@Valid @RequestBody FisicPersonDTO personDTO) {
        return pessoaService.cadastrarPessoa(personDTO);
    }

    @GetMapping
    public ResponseEntity<List<FisicPersonDTO>> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FisicPersonDTO> buscarPessoaPorId(@PathVariable Long id) {
        return pessoaService.buscarporId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FisicPersonDTO> atualizarPessoa(@PathVariable Long id, @RequestBody Person pessoa) {
        return pessoaService.atualizarPEssoa(id, pessoa);
    }

}
