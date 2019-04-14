package com.phablo.tassio.salao.api.service;

import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.PersonDTO;
import com.phablo.tassio.salao.api.model.mapper.PersonMapper;
import com.phablo.tassio.salao.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PersonMapper personMapper;

    public PersonService() {

    }

    public PersonService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public ResponseEntity<PersonDTO> cadastrarPessoa(PersonDTO personDTO){

        Person pessoaSalva = pessoaRepository.save(personMapper.personDTOToPerson(personDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri();

        return ResponseEntity.created(uri).body(personMapper.personToPersonDto(pessoaSalva));
    }

    public ResponseEntity<List<PersonDTO>> listarPessoas() {
        return ResponseEntity.ok(pessoaRepository.findAll().stream().map(person -> personMapper.personToPersonDto(person)).collect(Collectors.toList()));
    }


    public void excluirPessoa(Long id) {

        pessoaRepository.deleteById(id);
    }

    public ResponseEntity<PersonDTO> atualizarPEssoa(Long id, Person pessoa) {

        Person pessoaSalva = getPessoaPorId(id);
        BeanUtils.copyProperties(pessoa,pessoaSalva, "id");

        return ResponseEntity.ok(personMapper.personToPersonDto(pessoaRepository.save(pessoaSalva)));
    }

    public ResponseEntity<PersonDTO> buscarporId(Long id) {

        return ResponseEntity.ok(personMapper.personToPersonDto(getPessoaPorId(id)));
    }

    private Person getPessoaPorId(Long id) {

      return pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("A pessoa procurada não está cadastrada.", 1));

    }

}
