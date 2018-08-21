package com.maple.entity;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer user;
    private Integer stock;
    private Integer quanlity;
    private Date gmtCreate;
    private Date gmtModified;

    public Cart() {}

    public Cart(Integer user, Integer stock, Integer quanlity) {
        this.user = user;
        this.stock = stock;
        this.quanlity = quanlity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", stock=" + stock +
                ", quanlity=" + quanlity +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}