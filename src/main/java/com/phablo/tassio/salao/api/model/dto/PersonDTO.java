package com.phablo.tassio.salao.api.model.dto;

import com.phablo.tassio.salao.api.model.interfaces.ApplicationDTO;

import java.time.LocalDate;

public class PersonDTO implements ApplicationDTO {

    private String fullName;
    private String documentNumber;
    private String telephoneNumber;
    private String email;
    private LocalDate inclusionDate;

    public PersonDTO() {
        this.inclusionDate = LocalDate.now();
    }

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

    public LocalDate getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(LocalDate inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

}
