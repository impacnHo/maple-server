package com.maple.dao;

import com.maple.dto.OrderDTO;
import com.maple.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void saveOrder() {
        Order order = new Order();
        order.setUser(1);
        order.setStatus(0);
        order.setTotal(new BigDecimal(4396));
        orderDao.saveOrder(order);
        System.out.println("generate id = " + order.getId());
    }

    @Test
    public void listOrderTest() {
        List<OrderDTO> orderDTOList = orderDao.listOrder(1);
        for (OrderDTO orderDTO : orderDTOList) {
            System.out.println(orderDTO.toString());
        }
    }

}