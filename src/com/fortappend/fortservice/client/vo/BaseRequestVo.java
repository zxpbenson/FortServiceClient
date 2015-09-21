package com.fortappend.fortservice.client.vo;

public class BaseRequestVo {

    private String fortEnv;
    private String operation;
    
    public BaseRequestVo(){
        setFortEnv("true");
    }
    
    public String getFortEnv() {
        return fortEnv;
    }

    public void setFortEnv(String fortEnv) {
        this.fortEnv = fortEnv;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
