package com.phablo.tassio.salao.api.repository;

import com.phablo.tassio.salao.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Long > {

}
