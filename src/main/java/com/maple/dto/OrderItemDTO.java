package com.maple.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单列表、订单详情中的商品项
 */
public class OrderItemDTO implements Serializable {
    private static final long serialVersionUID = -4974742814932868418L;
    private String productNum;
    private String name;
    private String subName;
    private String stockName;
    private BigDecimal unitPrice;
    private Integer quanlity;
    private BigDecimal unitTotal;

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

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    public BigDecimal getUnitTotal() {
        return unitTotal;
    }

    public void setUnitTotal(BigDecimal unitTotal) {
        this.unitTotal = unitTotal;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "productNum='" + productNum + '\'' +
                ", name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                ", stockName='" + stockName + '\'' +
                ", unitPrice=" + unitPrice +
                ", quanlity=" + quanlity +
                ", UnitTotal=" + unitTotal +
                '}';
    }
}
