package com.maple.dto;

import java.io.Serializable;

/**
 * 在商品详情请求添加购物车的传入对象
 */
public class CartDTO implements Serializable {
    private static final long serialVersionUID = -9035937423299159194L;
    private Integer StockId;
    private Integer quanlity;

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
                ", StockId=" + StockId +
                ", quanlity=" + quanlity +
                '}';
    }
}
