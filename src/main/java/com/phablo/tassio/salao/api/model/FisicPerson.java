package com.phablo.tassio.salao.api.model;

import com.phablo.tassio.salao.api.model.enums.SexType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "fisic_person")
public class FisicPerson implements Serializable {

    private static final long serialVersionUID = 5748570390671813955L;

    @Id
    private Long id;

    @NotNull
    private LocalDate dateBirth;

    @NotBlank
    @Size(max =  100)
    private String fullName;

    @Size(max =  30)
    private String nickName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SexType sexType;

    @MapsId
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person",
            foreignKey = @ForeignKey(name = "fisic_person_ibfk_1"))
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FisicPerson that = (FisicPerson) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
