package com.maple.service;

import com.maple.dto.OrderDetailDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void saveOrder() {
        int[] cartIds = {6, 7};
        orderService.saveOrder(1, cartIds, 2);
    }

    @Test
    public void deleteOrder() {
    }

    @Test
    public void cancelOrder() {
    }

    @Test
    public void payForOrder() {
    }

    @Test
    public void listOrder() {
    }

    @Test
    public void getOrderDetial() {
        OrderDetailDTO orderDetailDTO = orderService.getOrderDetial(34);
        System.out.println(orderDetailDTO.toString());
    }
}