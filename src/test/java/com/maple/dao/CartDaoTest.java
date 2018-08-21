package com.maple.dao;

import com.maple.dto.CartItemDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartDaoTest {
    @Autowired
    private CartDao cartDao;

    @Test
    public void listCart() {
        List<CartItemDTO> cartItemDTOS = cartDao.listCart(1);
        for (CartItemDTO c : cartItemDTOS) {
            System.out.println(c.toString());
        }
    }
}