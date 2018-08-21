package com.maple.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1791459928007672846L;
    private Integer id;
    private Integer status;
    private BigDecimal total;
    private List<OrderItemDTO> orderItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", status=" + status +
                ", total=" + total +
                ", orderItems=" + orderItems +
                '}';
    }
}
