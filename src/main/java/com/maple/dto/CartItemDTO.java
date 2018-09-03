package com.maple.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车列表中的购物车项
 */
public class CartItemDTO implements Serializable {
    private static final long serialVersionUID = -9035937423299159194L;
    private Integer id;
    private String name;
    private String subName;
    private String productNum;
    private Integer stockId;
    private String stockName;
    private BigDecimal price;
    private Integer quanlity;
    private Integer maxQuanlity;

    public CartItemDTO() {
    }

    public CartItemDTO(Integer id, String name, String subName, String productNum, Integer stockId, String stockName, BigDecimal price,Integer quanlity, Integer maxQuanlity) {
        this.id = id;
        this.name = name;
        this.subName = subName;
        this.productNum = productNum;
        this.stockId = stockId;
        this.stockName = stockName;
        this.price = price;
        this.quanlity = quanlity;
        this.maxQuanlity = maxQuanlity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    public Integer getMaxQuanlity() {
        return maxQuanlity;
    }

    public void setMaxQuanlity(Integer maxQuanlity) {
        this.maxQuanlity = maxQuanlity;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                ", productNum='" + productNum + '\'' +
                ", stockId=" + stockId +
                ", stockName='" + stockName + '\'' +
                ", price=" + price +
                ", quanlity=" + quanlity +
                ", maxQuanlity=" + maxQuanlity +
                '}';
    }
}
