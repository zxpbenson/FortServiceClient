package com.fortappend.fortservice.client.vo;

public enum FlagEnum {
    
    SUCCESS("success"),
    FAIL("fail"),
    PERSON_NOT_EXISTS("personNotExists"),
    NO_AUTHORIZATION("noAuthorization");

    FlagEnum(String name){
        this.name = name;
    }
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
