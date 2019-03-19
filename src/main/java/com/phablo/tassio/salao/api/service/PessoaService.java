package com.phablo.tassio.salao.api.service;

import com.phablo.tassio.salao.api.model.Pessoa;
import com.phablo.tassio.salao.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService() {

    }

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public ResponseEntity<Pessoa> cadastrarPessoa(Pessoa pessoa){

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoaSalva);
    }

    public ResponseEntity<List<Pessoa>> listarPessoas() {

        return ResponseEntity.ok(pessoaRepository.findAll());
    }


    public void excluirPessoa(Long id) {

        pessoaRepository.deleteById(id);
    }

    public ResponseEntity<Pessoa> atualizarPEssoa(Long id, Pessoa pessoa) {

        Pessoa pessoaSalva = getPessoaPorId(id);
        BeanUtils.copyProperties(pessoa,pessoaSalva, "id");

        return ResponseEntity.ok(pessoaRepository.save(pessoaSalva));
    }

    public ResponseEntity<Pessoa> buscarporId(Long id) {

        return ResponseEntity.ok(getPessoaPorId(id));
    }

    private Pessoa getPessoaPorId(Long id) {

        Optional<Pessoa> pessoaSalva = pessoaRepository.findById(id);

        if(pessoaSalva.isPresent()) {

            return pessoaSalva.get();
        }

        throw new EmptyResultDataAccessException("A pessoa procurada não está cadastrada.", 1);
    }
}
