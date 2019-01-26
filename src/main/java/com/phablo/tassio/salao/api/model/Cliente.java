package com.phablo.tassio.salao.api.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//@Entity
//@Table(name= "cliente")
public class Cliente {

    private Long id;
    private Pessoa pessoa;
    private LocalDate dataCadastro;
    private List<Servico> servicosFeitos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Servico> getServicosFeitos() {
        return servicosFeitos;
    }

    public void setServicosFeitos(List<Servico> servicosFeitos) {
        this.servicosFeitos = servicosFeitos;
    }

}
