package com.cts.model;

public class CaseModel {
    private int clientId;
    private String openDate;
    private String closeDate;
    private int caseNum;
    private String des;
    private String status;

    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public String getCloseDate() {
        return closeDate;
    }
    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(int caseNum) {
        this.caseNum = caseNum;
    }
    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


}
