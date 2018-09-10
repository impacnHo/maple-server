package com.maple.dao;

import com.maple.dto.OrderDTO;
import com.maple.entity.Order;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
    @Select("SELECT id,user,status,total,payment,account,gmt_create AS gmtCreate FROM maple_order WHERE id = #{id} AND user = #{userId}")
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
     * @param status
     * @param total
     * @param payment
     * @param account
     * @param userId
     * @return
     */
    @Update("UPDATE maple_order " +
            "SET status = #{status},total = #{total},payment = #{payment},account = #{account},gmt_modified = now() " +
            "WHERE id = #{id} AND user = #{userId}")
    Integer updateOrder(@Param("status") Integer status, @Param("total") BigDecimal total, @Param("payment") Integer payment, @Param("account") String account, @Param("id") Integer id, @Param("userId") Integer userId);

    /**
     * 查看订单列表
     *
     * @param id
     * @return
     */
    @Select("SELECT id,status,total,gmt_create AS createTime FROM maple_order WHERE user = #{userId}")
    @Results({
            // 必须定义 id = true 否则id = null
            @Result(property = "id", column = "id", id = true),
            @Result(property = "orderItems", column = "id", many = @Many(select = "com.maple.dao.OrderItemDao.listOrderItemByOrderId"))
    })
    List<OrderDTO> listOrder(@Param("userId") Integer id);
}
