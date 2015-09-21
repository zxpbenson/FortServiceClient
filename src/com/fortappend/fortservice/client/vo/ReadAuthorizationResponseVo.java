package com.fortappend.fortservice.client.vo;

public class ReadAuthorizationResponseVo extends BaseResponseVo {
    
    private BaseResourceVo[] resultSet;

    public BaseResourceVo[] getResultSet() {
        return resultSet;
    }

    public void setResultSet(BaseResourceVo[] resultSet) {
        this.resultSet = resultSet;
    }

}
