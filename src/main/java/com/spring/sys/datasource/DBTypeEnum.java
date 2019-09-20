package com.spring.sys.datasource;

public enum DBTypeEnum {
    master("master"), slave("slave");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}