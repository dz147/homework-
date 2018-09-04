package com.dz.phone.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class phone {
    private int id ;
    private String name;
    private BigDecimal price ;
    private Date dateTime ;
    private int  Salesvolume ;
    private int inventory ;
    private int  state ;
    private String picture ;
    public phone(){

    }
    public phone(int id, String name, BigDecimal price, Date dateTime, int salesvolume, int inventory, int state, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateTime = dateTime;
        Salesvolume = salesvolume;
        this.inventory = inventory;
        this.state = state;
        this.picture = picture;
    }
    public phone(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public phone( String name, BigDecimal price, Date dateTime, int salesvolume, int inventory, int state, String picture) {
        this.name = name;
        this.price = price;
        this.dateTime = dateTime;
        Salesvolume = salesvolume;
        this.inventory = inventory;
        this.state = state;
        this.picture = picture;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getSalesvolume() {
        return Salesvolume;
    }

    public void setSalesvolume(int salesvolume) {
        Salesvolume = salesvolume;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateTime=" + dateTime +
                ", Salesvolume=" + Salesvolume +
                ", inventory=" + inventory +
                ", state=" + state +
                ", picture='" + picture + '\'' +
                '}';
    }
}
