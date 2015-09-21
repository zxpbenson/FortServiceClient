package com.fortappend.fortservice.client.vo;

public class WriteItilAuthorizationRequestVo extends BaseRequestVo {

    private ItilResourceVo[] dataSet;

    public WriteItilAuthorizationRequestVo() {
        this.setOperation(OperationEnum.WRITE_ITIL_AUTHORIZATION.getName());
    }

    public ItilResourceVo[] getDataSet() {
        return dataSet;
    }

    public void setDataSet(ItilResourceVo[] dataSet) {
        this.dataSet = dataSet;
    }

}
