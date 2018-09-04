package com.dz.entity;

import java.math.BigDecimal;

public class Product {
   private int pno;             //产品主键
    private String pname ;      //产品介绍
    private int ptid ;          //产品类型外键
    private BigDecimal price ;  //产品价格
    private String details ;    //产品详情
    private int state ;         //状态上架还是下架，默认是上架
    private String prcture ;    //图片地址名称

    public Product(int pno, String pname, int ptid, BigDecimal price, String details, int state, String prcture) {
        this.pno = pno;
        this.pname = pname;
        this.ptid = ptid;
        this.price = price;
        this.details = details;
        this.state = state;
        this.prcture = prcture;
    }

    public Product() {
    }

    public Product(String pname, int ptid, BigDecimal price, String details, int state, String prcture) {
        this.pname = pname;
        this.ptid = ptid;
        this.price = price;
        this.details = details;
        this.state = state;
        this.prcture = prcture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pno=" + pno +
                ", pname='" + pname + '\'' +
                ", ptid=" + ptid +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", state=" + state +
                ", prcture='" + prcture + '\'' +
                '}';
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPtid() {
        return ptid;
    }

    public void setPtid(int ptid) {
        this.ptid = ptid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPrcture() {
        return prcture;
    }

    public void setPrcture(String prcture) {
        this.prcture = prcture;
    }
}
