package com.phablo.tassio.salao.api.service;

import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.PersonDTO;
import com.phablo.tassio.salao.api.model.interfaces.ManagerDTO;
import com.phablo.tassio.salao.api.model.interfaces.ApplicationDTO;
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
public class PersonService implements ManagerDTO<Person, Long> {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PersonService() {

    }

    public PersonService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public ResponseEntity<ApplicationDTO> cadastrarPessoa(PersonDTO personDTO){

        Person pessoaSalva = pessoaRepository.save(convertToEntity(personDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri();

        return ResponseEntity.created(uri).body(convertToDTO(pessoaSalva));
    }

    public ResponseEntity<List<ApplicationDTO>> listarPessoas() {
        return ResponseEntity.ok(pessoaRepository.findAll().stream().map(person -> convertToDTO(person)).collect(Collectors.toList()));
    }


    public void excluirPessoa(Long id) {

        pessoaRepository.deleteById(id);
    }

    public ResponseEntity<ApplicationDTO> atualizarPEssoa(Long id, Person pessoa) {

        Person pessoaSalva = getPessoaPorId(id);
        BeanUtils.copyProperties(pessoa,pessoaSalva, "id");

        return ResponseEntity.ok(convertToDTO(pessoaRepository.save(pessoaSalva)));
    }

    public ResponseEntity<ApplicationDTO> buscarporId(Long id) {

        return ResponseEntity.ok(convertToDTO(getPessoaPorId(id)));
    }

    private Person getPessoaPorId(Long id) {

      return pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("A pessoa procurada não está cadastrada.", 1));

    }

    @Override
    public ApplicationDTO convertToDTO(Person clazz) {
        PersonDTO personDTO = new PersonDTO();
        BeanUtils.copyProperties(clazz, personDTO, "id");
        return personDTO;
    }

    @Override
    public Person convertToEntity(ApplicationDTO simpleDTO) {
        Person  person = new Person();
        BeanUtils.copyProperties(simpleDTO, person, "id");
        return person;
    }
}
