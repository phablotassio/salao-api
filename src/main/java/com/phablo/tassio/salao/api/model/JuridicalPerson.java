package com.phablo.tassio.salao.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @JoinColumn(name = "ID_JURIDICAL_PERSON", foreignKey = @ForeignKey(name = "FK_PERSON_TB_JURIDICAL_PERSON"))
    private Person person;

    @Size(max = 100)
    @Column(name = "FANTASY_NAME")
    private String fantasyName;

    @NotBlank
    @Size(max = 100)
    @Column(name = "SOCIAL_REASON")
    private String socialReason;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_GROUP_PERSON", foreignKey = @ForeignKey(name = "FK_GROUP_PERSON_TB_JURIDICAL_PERSON"))
    private GroupPerson groupPerson;

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

    public GroupPerson getGroupPerson() {
        return groupPerson;
    }

    public void setGroupPerson(GroupPerson groupPerson) {
        this.groupPerson = groupPerson;
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
