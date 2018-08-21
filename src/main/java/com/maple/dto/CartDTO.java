package com.maple.dto;

import java.io.Serializable;

public class CartDTO implements Serializable {
    private static final long serialVersionUID = -9035937423299159194L;
    private Integer userId;
    private Integer StockId;
    private Integer quanlity;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStockId() {
        return StockId;
    }

    public void setStockId(Integer stockId) {
        StockId = stockId;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "userId=" + userId +
                ", StockId=" + StockId +
                ", quanlity=" + quanlity +
                '}';
    }
}
