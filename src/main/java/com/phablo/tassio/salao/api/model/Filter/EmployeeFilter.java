package com.phablo.tassio.salao.api.model.Filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EmployeeFilter extends SimpleFilter {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate admissionDate;
    private String fullName;
    private Long idGroupPerson;

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getIdGroupPerson() {
        return idGroupPerson;
    }

    public void setIdGroupPerson(Long idGroupPerson) {
        this.idGroupPerson = idGroupPerson;
    }
}
