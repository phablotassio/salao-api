package com.phablo.tassio.salao.api.service;

import com.phablo.tassio.salao.api.model.JuridicalPerson;
import com.phablo.tassio.salao.api.repository.JuridicalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class JuridicalPersonService {

    @Autowired
    private JuridicalPersonRepository repository;

    public JuridicalPerson findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("A pessoa procurada não está cadastrada.", 1));
    }
}
