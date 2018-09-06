package com.maple.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1791459928007672846L;
    private Integer id;
    private Integer status;
    private BigDecimal total;
    private List<OrderItemDTO> orderItems;
    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", status=" + status +
                ", total=" + total +
                ", orderItems=" + orderItems +
                ", createTime=" + createTime +
                '}';
    }
}
