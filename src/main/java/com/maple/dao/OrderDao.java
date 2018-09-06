package com.maple.dao;

import com.maple.dto.OrderDTO;
import com.maple.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    @Insert("INSERT INTO maple_order(user,status,total,gmt_create,gmt_modified) " +
            "VALUES (#{user},#{status},#{total},now(),now())")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Integer saveOrder(Order order);

    /**
     * 查看订单
     *
     * @param id
     * @return
     */
    @Select("SELECT id,user,status,total,payment,account FROM maple_order WHERE id = #{id} AND user = #{userId}")
    Order getOrder(@Param("id") Integer id, @Param("userId") Integer userId);

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM order WHERE id = #{id}")
    Integer deleteOrder(@Param("id") Integer id);

    /**
     * 更新订单
     *
     * @param order
     * @return
     */
    @Update("UPDATE order " +
            "SET status = #{status},total = #{total},payment = #{payment},account = #{account},gmt_modified = now() " +
            "WHERE id = #{id}")
    Integer updateOrder(Order order);

    /**
     * 查看订单列表
     *
     * @param id
     * @return
     */
    @Select("SELECT id,status,total FROM maple_order WHERE user = #{userId}")
    @Results({
            // 必须定义 id = true 否则id = null
            @Result(property = "id", column = "id", id = true),
            @Result(property = "orderItems", column = "id", many = @Many(select = "com.maple.dao.OrderItemDao.listOrderItemByOrderId"))
    })
    List<OrderDTO> listOrder(@Param("userId") Integer id);
}
