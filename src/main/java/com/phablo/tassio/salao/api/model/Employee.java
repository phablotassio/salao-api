package com.phablo.tassio.salao.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_EMPLOYEE")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Employee implements Serializable {

    private static final long serialVersionUID = -2507366873663698375L;

    @Id
    private Long id;

    @MapsId
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_EMPLOYEE", foreignKey = @ForeignKey(name = "FK_FISIC_PERSON_TB_EMPLOYEE"))
    private FisicPerson fisicPerson;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROLE", foreignKey = @ForeignKey(name = "FK_ROLE_TB_EMPLOYEE"))
    private Role role;

    @NotNull
    @Column(name = "ADMISSION_DATE", updatable = false)
    private LocalDate admissionDate;

    @Column(name = "WITHDRAW_DATE", updatable = false)
    private LocalDate withdrawDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_JURIDICAL_PERSON", foreignKey = @ForeignKey(name = "FK_JURIDICAL_PERSON_TB_EMPLOYEE"))
    private JuridicalPerson juridicalPerson;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_GROUP_PERSON", foreignKey = @ForeignKey(name = "FK_GROUP_PERSON_TB_EMPLOYEE"))
    private GroupPerson groupPerson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FisicPerson getFisicPerson() {
        return fisicPerson;
    }

    public void setFisicPerson(FisicPerson fisicPerson) {
        this.fisicPerson = fisicPerson;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(LocalDate withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    public JuridicalPerson getJuridicalPerson() {
        return juridicalPerson;
    }

    public void setJuridicalPerson(JuridicalPerson juridicalPerson) {
        this.juridicalPerson = juridicalPerson;
    }

    public GroupPerson getGroupPerson() {
        return groupPerson;
    }

    public void setGroupPerson(GroupPerson groupPerson) {
        this.groupPerson = groupPerson;
    }

    @PrePersist
    public void insertInclusionDate() {
        if (this.admissionDate == null) {
            this.admissionDate = LocalDate.now();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
