package com.spring.base.sys.datasource;

public enum DBTypeEnum {
    MASTER("master"), SLAVE("slave");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}