package com.phablo.tassio.salao.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "TB_GROUP_PERSON")
public class GroupPerson implements Serializable {

    private static final long serialVersionUID = 3850643478896679679L;
    private Long id;
    private String description;

    @Id
    @Column(name = "ID_GROUP_PERSON")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DESCRIPTION")
    @NotBlank
    @Size(max = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
