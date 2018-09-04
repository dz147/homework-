package com.dz.entity;

public class Users {
    private int  uid ;      //用户主键
    private String uname ;  //用户账号
    private String upwd  ;  //用户密码
    private String uphone ; //用户手机号
    private String uqqyx ;  //用户邮箱

    public Users(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }
    public Users(int uid ,String uname, String upwd, String uphone, String uqqyx) {
        this.uid=uid;
        this.uname = uname;
        this.upwd = upwd;
        this.uphone = uphone;
        this.uqqyx = uqqyx;
    }
    public Users( String uname, String upwd, String uphone, String uqqyx) {
        this.uname = uname;
        this.upwd = upwd;
        this.uphone = uphone;
        this.uqqyx = uqqyx;
    }public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uqqyx='" + uqqyx + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUqqyx() {
        return uqqyx;
    }

    public void setUqqyx(String uqqyx) {
        this.uqqyx = uqqyx;
    }
}
