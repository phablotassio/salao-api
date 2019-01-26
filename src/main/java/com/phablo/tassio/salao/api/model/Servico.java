package com.phablo.tassio.salao.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

//@Entity
//@Table(name="Servico")
public class Servico {

    private String servico;
    private Funcionario funcionario;
    private LocalDate dataServico;
    private Cliente cliente;
}
