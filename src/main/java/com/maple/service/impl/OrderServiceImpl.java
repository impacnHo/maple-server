package com.maple.service.impl;

import com.maple.dao.*;
import com.maple.dto.OrderDTO;
import com.maple.dto.OrderDetailDTO;
import com.maple.dto.OrderItemDTO;
import com.maple.entity.*;
import com.maple.service.OrderService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private OrderConsigneeDao orderConsigneeDao;
    @Autowired
    private UserConsigneeDao userConsigneeDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private StockDao stockDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrder(Integer userId, int[] cartIds, Integer userConsigneeId) {
        int orderId = 0;
        BigDecimal total = new BigDecimal(0);
        BigDecimal subTotal;
        List<OrderItem> orderItems = new ArrayList<>();
        Cart cart;
        Stock stock;
        OrderItem orderItem;

        // 检查库存量是否充足，计算总金额
        for (int i = 0; i < cartIds.length; i++) {
            cart = cartDao.getCartForTotal(cartIds[i]);
            stock = stockDao.getStock(cart.getStock());
            if (cart.getQuanlity() > stock.getQuanlity()) {
                // 库存不足，结束
                return orderId;
            } else {
                // 库存充足，计算总金额，减少库存量
                stock.setQuanlity(stock.getQuanlity() - cart.getQuanlity());
                stockDao.updateStock(stock);

                orderItem = new OrderItem();
                orderItem.setStock(cart.getStock());
                orderItem.setQuanlity(cart.getQuanlity());
                BigDecimal unitPrice = productDao.getPriceByStockId(cart.getStock());
                orderItem.setUnitPrice(unitPrice);
                orderItems.add(orderItem);
                subTotal = unitPrice.multiply(new BigDecimal(cart.getQuanlity()));
                total = total.add(subTotal);
            }
        }

        // 新增订单
        System.out.println("新增订单");
        Order order = new Order();
        order.setUser(userId);
        order.setStatus(0);// 初始状态 - 未支付
        order.setTotal(total);
        orderDao.saveOrder(order);
        orderId = order.getId();

        // 新增订单商品项目
        System.out.println("新增订单商品");
        for (OrderItem oi : orderItems) {
            oi.setOrderId(orderId);
            orderItemDao.saveOrderItem(oi);
        }

        // 新增订单配送信息
        System.out.println("新增配送信息");
        UserConsignee userConsignee = userConsigneeDao.getUserConsignee(userConsigneeId);
        OrderConsignee orderConsignee = new OrderConsignee();
        orderConsignee.setName(userConsignee.getName());
        orderConsignee.setTel(userConsignee.getTel());
        orderConsignee.setAddress(userConsignee.getAddress());
        orderConsignee.setId(orderId);
        orderConsigneeDao.saveOrderConsignee(orderConsignee);

        // 删除已选购物车项目
        System.out.println("删除购物车");
        for (int i = 0; i < cartIds.length; i++) {
            cartDao.deleteCart(cartIds[i], userId);
        }

        return orderId;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOrder(Integer orderId) {
        return orderDao.deleteOrder(orderId) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean cancelOrder(Integer orderId, Integer userId) {
        Stock stock;

        // 获取订单实体，更新状态
        Order order = orderDao.getOrder(orderId, userId);
        order.setStatus(1);

        // 获取订单商品项，恢复库存
        List<OrderItem> orderItems = orderItemDao.listSimpleOrderItem(orderId);
        for (OrderItem oi : orderItems) {
            stock = stockDao.getStock(oi.getStock());
            int orderItemQuanlity = oi.getQuanlity();
            stock.setQuanlity(stock.getQuanlity() + orderItemQuanlity);
            stockDao.updateStock(stock);
        }

        return orderDao.updateOrder(order.getStatus(), order.getTotal(), order.getPayment(), order.getAccount(), orderId, userId) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean payForOrder(Integer orderId, Integer userId, Integer payment, String account) {
        Order order = orderDao.getOrder(orderId, userId);
        order.setPayment(payment);
        order.setAccount(account);
        order.setStatus(2);
        return orderDao.updateOrder(order.getStatus(), order.getTotal(), order.getPayment(), order.getAccount(), orderId, userId) != null;
    }

    @Override
    public List<OrderDTO> listOrder(Integer userId) {
        return orderDao.listOrder(userId);
    }

    @Override
    public OrderDetailDTO getOrderDetial(Integer orderId, Integer userId) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        Order order = orderDao.getOrder(orderId, userId);
        OrderConsignee orderConsignee = orderConsigneeDao.getOrderConsignee(order.getId());
        List<OrderItemDTO> orderItemDTOS = orderItemDao.listOrderItemByOrderId(order.getId());

        orderDetailDTO.setId(order.getId());
        orderDetailDTO.setStatus(order.getStatus());
        orderDetailDTO.setAccount(order.getAccount());
        orderDetailDTO.setPayment(order.getPayment());
        orderDetailDTO.setTotal(order.getTotal());
        orderDetailDTO.setName(orderConsignee.getName());
        orderDetailDTO.setAddress(orderConsignee.getAddress());
        orderDetailDTO.setTel(orderConsignee.getTel());
        orderDetailDTO.setOrderItemDTOS(orderItemDTOS);
        orderDetailDTO.setCreateTime(order.getGmtCreate());
        return orderDetailDTO;
    }
}
