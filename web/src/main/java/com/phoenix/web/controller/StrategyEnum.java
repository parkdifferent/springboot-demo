package com.phoenix.web.controller;


public enum StrategyEnum {

    A(1, "A strategy"),
    B(2, "B strategy")

    ;

    private Integer type;

    private String desc;

    StrategyEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
