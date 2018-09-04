package com.dz.entity;

public class proType {
    private int pid ;           //产品类型ID
    private String pname;       //产品名称

    public proType(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }
    public proType() { }

    @Override
    public String toString() {
        return "proType{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
