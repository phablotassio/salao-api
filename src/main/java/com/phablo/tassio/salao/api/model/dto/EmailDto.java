package com.phablo.tassio.salao.api.model.dto;

public class EmailDto {

    private String desc;
    private Boolean main;
    private Type type;

    public EmailDto(String desc, Boolean main) {
        this.desc = desc;
        this.main = main;
    }

    public EmailDto(String desc) {
        this.desc = desc;
    }

    public EmailDto() {

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
