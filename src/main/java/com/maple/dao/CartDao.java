package com.maple.dao;

import com.maple.dto.CartItemDTO;
import com.maple.entity.Cart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao {

    /**
     * 新增购物车
     *
     * @param cart
     * @return
     */
    @Insert("INSERT INTO cart(user,stock,quanlity,gmt_create,gmt_modified) " +
            "VALUES(#{user},#{stock},#{quanlity},now(),now())")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Integer saveCart(Cart cart);

    /**
     * 根据用户id和购物车id删除购物车
     *
     * @param id
     * @param userId
     */
    @Delete("DELETE FROM cart WHERE id = #{id} AND user = #{userId}")
    Integer deleteCart(@Param("id") Integer id, @Param("userId") Integer userId);

    /**
     * 更新购物车
     *
     * @param id
     * @param userId
     * @param quanlity
     */
    @Update("UPDATE cart " +
            "SET quanlity = #{quanlity},gmt_modified = now() " +
            "WHERE id = #{id} AND user = #{userId}")
    Integer updateCart(@Param("id") Integer id, @Param("userId") Integer userId, @Param("quanlity") Integer quanlity);

    /**
     * 根据用户id获取购物车列表
     *
     * @param id
     * @return
     */
    @Select("SELECT c.id AS id,p.name AS name,p.sub_name AS subName," +
            "p.product_num AS productNum,s.id AS stockId,s.name AS stockName," +
            "c.quanlity AS quanlity,s.quanlity AS maxQuanlity " +
            "FROM cart as c,product as p,stock as s,user_registry as u " +
            "WHERE c.stock = s.id AND s.product_id = p.id AND c.user = u.id AND u.id = #{id}")
    List<CartItemDTO> listCart(@Param("id") Integer id);

    /**
     * 提交订单时，计算总金额
     *
     * @param id
     * @return
     */
    @Select("SELECT stock,quanlity FROM cart WHERE id = #{id}")
    Cart getCartForTotal(@Param("id") Integer id);
}
