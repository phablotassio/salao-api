package com.phablo.tassio.salao.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_ROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = -4535443173320758680L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROLE")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return getId().equals(role.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
