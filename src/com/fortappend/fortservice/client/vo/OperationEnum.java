package com.fortappend.fortservice.client.vo;

public enum OperationEnum {
    
    READ_AUTHORIZATION("readAuthorization"),
    WRITE_ITIL_AUTHORIZATION("writeItilAuthorization"),
    GET_ITIL_AUTHORIZATION("getItilAuthorization");
    
    OperationEnum(String name){
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
