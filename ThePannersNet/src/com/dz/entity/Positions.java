package com.dz.entity;

public class Positions {
    private int psid;       //区域ID
    private int userid;     //户ID
    private String posis;   //区域信息
    private String pname;   //收件人
    private String phone;   //收货人电话

    public Positions() {
    }

    public Positions(int userid, String posis, String pname, String phone) {
        this.userid = userid;
        this.posis = posis;
        this.pname = pname;
        this.phone = phone;
    }

    public Positions(int psid, int userid, String posis, String pname, String phone) {
        this.psid = psid;
        this.userid = userid;
        this.posis = posis;
        this.pname = pname;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "psid=" + psid +
                ", userid=" + userid +
                ", posis='" + posis + '\'' +
                ", pname='" + pname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getPsid() {
        return psid;
    }

    public void setPsid(int psid) {
        this.psid = psid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPosis() {
        return posis;
    }

    public void setPosis(String posis) {
        this.posis = posis;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
