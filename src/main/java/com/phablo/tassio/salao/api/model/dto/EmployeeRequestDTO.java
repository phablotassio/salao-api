package com.phablo.tassio.salao.api.model.dto;

import com.phablo.tassio.salao.api.model.enums.SexType;

import java.time.LocalDate;

public class EmployeeRequestDTO {

    private String fullName;
    private String documentNumber;
    private String telephoneNumber;
    private String email;
    private LocalDate birthdate;
    private String nickName;
    private SexType sexType;
    private LocalDate admissionDate;
    private LocalDate withdrawDate;
    private Long idJuridicalPerson;
    private Long idRole;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public SexType getSexType() {
        return sexType;
    }

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
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

    public Long getIdJuridicalPerson() {
        return idJuridicalPerson;
    }

    public void setIdJuridicalPerson(Long idJuridicalPerson) {
        this.idJuridicalPerson = idJuridicalPerson;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
}
