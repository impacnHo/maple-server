package com.maple.dto;

import java.io.Serializable;

public class StockDTO implements Serializable {
    private static final long serialVersionUID = 8752696711145525330L;
    private Integer id;
    private String name;
    private Integer quanlity;

    public StockDTO() {}

    public StockDTO(Integer id, String name, Integer quanlity) {
        this.id = id;
        this.name = name;
        this.quanlity = quanlity;
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

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quanlity=" + quanlity +
                '}';
    }
}
