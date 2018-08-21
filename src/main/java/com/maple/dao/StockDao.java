package com.maple.dao;

import com.maple.entity.Stock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockDao {

    /**
     * 根据货号获取库存
     *
     * @param productNum
     * @return
     */
    @Select("SELECT s.id AS id,s.name AS name,quanlity AS quanlity" +
            "FROM stock as s,product as p " +
            "WHERE s.product_id = p.id AND p.product_num = #{productNum}")
    List<Stock> listStock(@Param("productNum") String productNum);

    /**
     * 通过库存id获取剩余量
     *
     * @param id
     * @return
     */
    @Select("SELECT id,quanlity FROM stock WHERE id = #{id}")
    Stock getStock(@Param("id") Integer id);

    /**
     * 更新库存
     * @param stock
     * @return
     */
    @Update("UPDATE stock " +
            "SET quanlity = #{quanlity},gmt_modified = now()" +
            "WHERE id = #{id}")
    Integer updateStock(Stock stock);
}
