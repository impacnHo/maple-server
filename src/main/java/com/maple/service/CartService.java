package com.maple.service;

import com.maple.dto.CartDTO;
import com.maple.dto.CartItemDTO;

import java.util.List;

public interface CartService {

    /**
     * 添加购物车
     *
     * @param cartDTO
     * @param userId
     * @return
     */
    boolean saveCart(CartDTO cartDTO, Integer userId);

    /**
     * 删除购物车
     *
     * @param id
     * @param userId
     * @return
     */
    boolean deleteCart(Integer id, Integer userId);

    /**
     * 修改购物车
     *
     * @param id
     * @param userId
     * @param quanlity
     * @return
     */
    boolean updateCart(Integer id, Integer userId, Integer quanlity);

    /**
     * 根据用户id获取购物车列表
     *
     * @param userId
     * @return
     */
    List<CartItemDTO> listCart(Integer userId);
}
