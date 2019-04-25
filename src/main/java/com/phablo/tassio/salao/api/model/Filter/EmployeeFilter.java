package com.phablo.tassio.salao.api.model.Filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EmployeeFilter {

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate admissionDate;
    private String fullName;

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
}
