package com.maple.service.impl;

import com.maple.dao.CartDao;
import com.maple.dto.CartDTO;
import com.maple.dto.CartItemDTO;
import com.maple.entity.Cart;
import com.maple.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveCart(CartDTO cartDTO) {
        // 转换
        Cart cart = new Cart(cartDTO.getUserId(), cartDTO.getStockId(), cartDTO.getQuanlity());
        // 获取用户id
        int uid = cartDTO.getUserId();
        // 获取用户购物车列表
        List<CartItemDTO> cartItemDTOS = cartDao.listCart(uid);
        // 检查是传入购物车项否已存在
        boolean flag = false;
        for (CartItemDTO cartItemDTO : cartItemDTOS) {
            if (cart.getStock().equals(cartItemDTO.getStockId())) {
                cart.setId(cartItemDTO.getId());
                cart.setQuanlity(cart.getQuanlity() + cartItemDTO.getQuanlity());
                flag = true;
                break;
            }
        }

        if (flag) {
            // 已存在，更新
            System.out.println("updating...");
            int cartId = cart.getId();
            int quanlity = cart.getQuanlity();
            return cartDao.updateCart(cartId, quanlity) != null;
        } else {
            // 新增购物车项目
            System.out.println("saving...");
            return cartDao.saveCart(cart) != null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCart(Integer id) {
        return cartDao.deleteCart(id) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateCart(Integer id, Integer quanlity) {
        return cartDao.updateCart(id, quanlity) != null;
    }

    @Override
    public List<CartItemDTO> listCart(Integer id) {
        return cartDao.listCart(id);
    }
}