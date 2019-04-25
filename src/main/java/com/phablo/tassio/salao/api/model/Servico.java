package com.phablo.tassio.salao.api.model;

import java.time.LocalDate;

//@Entity
//@Table(name="Servico")
public class Servico {

    private String servico;
    private Employee funcionario;
    private LocalDate dataServico;
    private Cliente cliente;
}
