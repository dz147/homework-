package com.dz.entity;

import java.math.BigDecimal;

public class OrderFrom {
    private int oid;              //订单ID
    private  int userid;
    private BigDecimal prices;   //金额
    private int position;        //收货地址信息
    private int state;

    @Override
    public String toString() {
        return "OrderFrom{" +
                "oid=" + oid +
                ", userid=" + userid +
                ", prices=" + prices +
                ", position=" + position +
                ", state=" + state +
                '}';
    }

    public OrderFrom(int oid, int userid, BigDecimal prices, int position, int state) {
        this.oid = oid;
        this.userid = userid;
        this.prices = prices;
        this.position = position;
        this.state = state;
    }

    public OrderFrom(int userid, BigDecimal prices, int position, int state) {
        this.userid = userid;
        this.prices = prices;
        this.position = position;
        this.state = state;
    }

    public OrderFrom() {
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(BigDecimal prices) {
        this.prices = prices;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
