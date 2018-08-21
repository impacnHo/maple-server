package com.maple.dao;

import com.maple.entity.OrderConsignee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderConsigneeDao {

    /**
     * 保存订单配送信息
     *
     * @param orderConsignee
     * @return
     */
    @Insert("INSERT INTO order_consignee(id,name,tel,address,gmt_create,gmt_modified) " +
            "VALUES(#{id},#{name},#{tel},#{address},now(),now())")
    Integer saveOrderConsignee(OrderConsignee orderConsignee);

    /**
     * 获取订单配送地址
     *
     * @param id
     * @return
     */
    @Select("SELECT name,tel,address FROM order_consignee WHERE id = #{id}")
    OrderConsignee getOrderConsignee(@Param("id") Integer id);

    /**
     * 删除配送信息
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM order_consignee WHERE id = #{id}")
    Integer deleteOrderConsignee(@Param("id") Integer id);
}
