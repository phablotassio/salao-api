package com.phablo.tassio.salao.api.service;

import com.phablo.tassio.salao.api.model.FisicPerson;
import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.FisicPersonDTO;
import com.phablo.tassio.salao.api.model.mapper.FisicPersonMapper;
import com.phablo.tassio.salao.api.repository.FisicPersonRepository;
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
public class FisicPersonService {

    @Autowired
    private FisicPersonRepository pessoaRepository;

    @Autowired
    private FisicPersonMapper personMapper;

    public ResponseEntity<FisicPersonDTO> cadastrarPessoa(FisicPersonDTO personDTO){

        FisicPerson fisicPerson = personMapper.personDTOToFisicPerson(personDTO);

        FisicPerson pessoaSalva = pessoaRepository.save(fisicPerson);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri();

        return ResponseEntity.created(uri).body(personMapper.personToPersonDto(pessoaSalva));
    }

    public ResponseEntity<List<FisicPersonDTO>> listarPessoas() {
        return ResponseEntity.ok(pessoaRepository.findAll().stream().map(person -> personMapper.personToPersonDto(person)).collect(Collectors.toList()));
    }


    public void excluirPessoa(Long id) {

        pessoaRepository.deleteById(id);
    }

    public ResponseEntity<FisicPersonDTO> atualizarPEssoa(Long id, Person pessoa) {

        FisicPerson pessoaSalva = getPessoaPorId(id);
        BeanUtils.copyProperties(pessoa,pessoaSalva, "id");

        return ResponseEntity.ok(personMapper.personToPersonDto(pessoaRepository.save(pessoaSalva)));
    }

    public ResponseEntity<FisicPersonDTO> buscarporId(Long id) {

        return ResponseEntity.ok(personMapper.personToPersonDto(getPessoaPorId(id)));
    }

    private FisicPerson getPessoaPorId(Long id) {

      return pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("A pessoa procurada não está cadastrada.", 1));

    }

}
