package com.phablo.tassio.salao.api.model.enums;

public enum SexType {
    M("Masculino"),
    F("Feminino");

    private String description;

    SexType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
