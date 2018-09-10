package com.maple.service;

import com.maple.dto.OrderDTO;
import com.maple.dto.OrderDetailDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void saveOrder() {
        int[] cartIds = {1};
        orderService.saveOrder(1, cartIds, 4);
    }

    @Test
    public void deleteOrder() {
    }

    @Test
    public void cancelOrder() {
    }

    @Test
    public void payForOrder() {
        System.out.println(orderService.payForOrder(34,1,1,"myaccount"));
    }

    @Test
    public void listOrder() {
        List<OrderDTO> orderDTOS = orderService.listOrder(1);
        for(OrderDTO orderDTO : orderDTOS) {
            System.out.println(orderDTO.toString());
        }
    }

    @Test
    public void getOrderDetial() {
        OrderDetailDTO orderDetailDTO = orderService.getOrderDetial(34,1);
        System.out.println(orderDetailDTO.toString());
    }

}