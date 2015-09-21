package com.fortappend.fortservice.client.vo;

public class ReadAuthorizationRequestVo extends BaseRequestVo{

    private String personAccount;
    
    public ReadAuthorizationRequestVo(){
        this.setOperation(OperationEnum.READ_AUTHORIZATION.getName());
    }

    public String getPersonAccount() {
        return personAccount;
    }

    public void setPersonAccount(String personAccount) {
        this.personAccount = personAccount;
    }
    
}
