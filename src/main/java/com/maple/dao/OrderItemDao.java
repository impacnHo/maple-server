package com.maple.dao;

import com.maple.dto.OrderItemDTO;
import com.maple.entity.OrderItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemDao {

    /**
     * 保存订单商品信息
     *
     * @param orderItem
     * @return
     */
    @Insert("INSERT INTO order_item(order_id,stock,quanlity,unit_price,gmt_create,gmt_modified) " +
            "VALUES(#{orderId},#{stock},#{quanlity},#{unitPrice},now(),now())")
    Integer saveOrderItem(OrderItem orderItem);

    /**
     * 获取订单的商品列表
     *
     * @param id
     * @return
     */
    @Select("SELECT product_num AS productNum,p.name AS name,sub_name AS subName," +
            "s.name AS stockName,oi.unitPrice AS unitPrice,oi.quanlity AS quanlity " +
            "FROM order_item AS oi,product AS p,stock AS s " +
            "WHERE oi.stock = s.id AND s.product_id = p.id AND oi.id = #{id}")
    List<OrderItemDTO> listOrderItem(@Param("id") Integer id);

    /**
     * 订单详情，获取订单的商品列表
     *
     * @param id
     * @return
     */
    @Select("SELECT product_num AS productNum,p.name AS name,sub_name AS subName," +
            "s.name AS stockName,oi.unit_price AS unitPrice,oi.quanlity AS quanlity,oi.unit_price*oi.quanlity AS unitTotal " +
            "FROM order_item AS oi,product AS p,stock AS s,maple_order as o " +
            "WHERE oi.stock = s.id AND s.product_id = p.id AND oi.order_id = o.id AND o.id = #{id}")
    List<OrderItemDTO> listOrderItemByOrderId(@Param("id") Integer id);

    /**
     * 删除订单的商品列表
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM order_item WHERE id = #{id}")
    Integer deleteOrderItem(@Param("id") Integer id);

    /**
     * 获取订单商品列
     *
     * @param id
     * @return
     */
    @Select("SELECT stock,quanlity FROM order_item WHERE order_id = #{id}")
    List<OrderItem> listSimpleOrderItem(@Param("id") Integer id);
}
