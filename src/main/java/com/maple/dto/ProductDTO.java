package com.maple.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 701690868932102360L;
    private String productNum;
    private String brandName;
    private String name;
    private String subName;
    private Date lanchDate;
    private String descr;
    private BigDecimal price;
    private List<StockDTO> stocks;

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public Date getLanchDate() {
        return lanchDate;
    }

    public void setLanchDate(Date lanchDate) {
        this.lanchDate = lanchDate;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<StockDTO> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockDTO> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productNum='" + productNum + '\'' +
                ", brandName='" + brandName + '\'' +
                ", name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                ", lanchDate=" + lanchDate +
                ", descr='" + descr + '\'' +
                ", price=" + price +
                ", sotcks=" + stocks +
                '}';
    }
}
