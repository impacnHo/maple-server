package com.maple.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品列表中的商品项
 */
public class ProductItemDTO implements Serializable {
    private static final long serialVersionUID = 6133301723273538155L;
    private String productNum;
    private String name;
    private String subName;
    private BigDecimal price;
    private Date date;

    public ProductItemDTO() {
    }

    public ProductItemDTO(String productNum, String name, String subName, BigDecimal price, Date date) {
        this.productNum = productNum;
        this.name = name;
        this.subName = subName;
        this.price = price;
        this.date = date;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ProductItemDTO{" +
                "productNum='" + productNum + '\'' +
                ", name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
