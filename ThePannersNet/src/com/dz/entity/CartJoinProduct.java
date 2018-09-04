package com.dz.entity;

import java.math.BigDecimal;

public class CartJoinProduct {
    private int cid;//购物车ID
    private String prcture;//图片名称
    private String pname;//商品名称
    private BigDecimal price;//商品单价
    private int number;//数量
    private BigDecimal prices;//商品总价

    @Override
    public String toString() {
        return "CartJoinProduct{" +
                "cid=" + cid +
                ", prcture='" + prcture + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", prices=" + prices +
                '}';
    }

    public CartJoinProduct() {
    }

    public CartJoinProduct(int cid, String prcture, String pname, BigDecimal price, int number, BigDecimal prices) {
        this.cid = cid;
        this.prcture = prcture;
        this.pname = pname;
        this.price = price;
        this.number = number;
        this.prices = prices;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getPrcture() {
        return prcture;
    }

    public void setPrcture(String prcture) {
        this.prcture = prcture;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(BigDecimal prices) {
        this.prices = prices;
    }
}
