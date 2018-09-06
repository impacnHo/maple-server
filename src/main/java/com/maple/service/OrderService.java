package com.maple.service;

import com.maple.dto.OrderDTO;
import com.maple.dto.OrderDetailDTO;
import com.maple.entity.Cart;
import io.swagger.models.auth.In;

import java.util.List;

public interface OrderService {

    /**
     * 保存订单，订单状态：0-待付款
     *
     * @param userId
     * @param cartIds
     * @param userConsigneeId
     * @return
     */
    Integer saveOrder(Integer userId, int[] cartIds, Integer userConsigneeId);

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    boolean deleteOrder(Integer orderId);

    /**
     * 取消订单，订单状态：1-已取消
     *
     * @param orderId
     * @param userId
     * @return
     */
    boolean cancelOrder(Integer orderId, Integer userId);

    /**
     * 支付订单
     *
     * @param orderId
     * @param userId
     * @param payment
     * @param account
     * @return
     */
    boolean payForOrder(Integer orderId, Integer userId, Integer payment, String account);

    /**
     * 根据用户id获取订单列表
     *
     * @param userId
     * @return
     */
    List<OrderDTO> listOrder(Integer userId);

    /**
     * 订单详情
     *
     * @param orderId
     * @param userId
     * @return
     */
    OrderDetailDTO getOrderDetial(Integer orderId, Integer userId);
}
