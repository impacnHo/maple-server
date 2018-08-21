package com.maple.service;

import com.maple.dto.CartDTO;
import com.maple.dto.CartItemDTO;

import java.util.List;

public interface CartService {

    /**
     * 添加购物车
     *
     * @param cartDTO
     * @return
     */
    boolean saveCart(CartDTO cartDTO);

    /**
     * 删除购物车
     *
     * @param id
     * @return
     */
    boolean deleteCart(Integer id);

    /**
     * 修改购物车
     *
     * @param id
     * @param quanlity
     * @return
     */
    boolean updateCart(Integer id, Integer quanlity);

    /**
     * 根据用户id获取购物车列表
     * @param id
     * @return
     */
    List<CartItemDTO> listCart(Integer id);
}
