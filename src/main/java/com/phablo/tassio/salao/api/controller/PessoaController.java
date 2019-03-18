package com.phablo.tassio.salao.api.controller;

import com.phablo.tassio.salao.api.model.Pessoa;
import com.phablo.tassio.salao.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/salao/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa (@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        return pessoaService.buscarporId(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.atualizarPEssoa(id, pessoa);
    }

}
