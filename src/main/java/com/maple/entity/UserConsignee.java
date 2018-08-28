package com.maple.entity;

import java.io.Serializable;
import java.util.Date;

public class UserConsignee implements Serializable {
    private static final long serialVersionUID = 1043291699366158890L;
    private Integer id;
    private Integer userId;
    private String name;
    private String tel;
    private String address;
    private Date gmtCreate;
    private Date gmtModified;

    public UserConsignee() {}

    public UserConsignee(Integer userId, String name, String tel, String address) {
        this.userId = userId;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "UserConsignee{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}