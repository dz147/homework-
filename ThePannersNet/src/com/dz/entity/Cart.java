package com.dz.entity;

import java.math.BigDecimal;

public class Cart {
    private int cid;            //购物车ID
    private int number;         //数量
    private int userid;         //用户ID
    private BigDecimal prices;  //金额
    private int ststus;         //购物车状态 结算与未结算 0为未结算
    private int p_id;           //商品信息ID
    private int o_id;           //订单表ID

    public Cart(int cid, int number, int userid, BigDecimal prices, int ststus, int p_id, int o_id) {
        this.cid = cid;
        this.number = number;
        this.userid = userid;
        this.prices = prices;
        this.ststus = ststus;
        this.p_id = p_id;
        this.o_id = o_id;
    } public Cart(int cid, int number, int userid) {
        this.cid = cid;
        this.number = number;
        this.userid = userid;
    }
    public Cart() {
    }
    public Cart( int number, int userid, BigDecimal prices, int ststus, int p_id) {
        this.number = number;
        this.userid = userid;
        this.prices = prices;
        this.ststus = ststus;
        this.p_id = p_id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public int getStstus() {
        return ststus;
    }

    public void setStstus(int ststus) {
        this.ststus = ststus;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", number=" + number +
                ", userid=" + userid +
                ", prices=" + prices +
                ", ststus=" + ststus +
                ", p_id=" + p_id +
                ", o_id=" + o_id +
                '}';
    }
}
