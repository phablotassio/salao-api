package com.phablo.tassio.salao.api.service;

import com.phablo.tassio.salao.api.model.Role;
import com.phablo.tassio.salao.api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public Role findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Role nao encotrada",1));
    }
}
