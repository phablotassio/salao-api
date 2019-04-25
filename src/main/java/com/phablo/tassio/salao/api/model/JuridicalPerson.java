package com.phablo.tassio.salao.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_JURIDICAL_PERSON")
public class JuridicalPerson implements Serializable {

    private static final long serialVersionUID = -1979806229990871079L;

    @Id
    private Long id;

    @Column(name = "DATE_OPENING")
    private LocalDate openingDate;

    @MapsId
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_JURIDICAL_PERSON", foreignKey = @ForeignKey(name = "FK_PERSON_TB_JURIRICAL_PERSON"))
    private Person person;

    @Size(max = 100)
    @Column(name = "FANTASY_NAME")
    private String fantasyName;

    @NotBlank
    @Size(max = 100)
    @Column(name = "SOCIAL_REASON")
    private String socialReason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JuridicalPerson that = (JuridicalPerson) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
