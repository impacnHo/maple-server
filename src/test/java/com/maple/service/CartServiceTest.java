package com.maple.service;

import com.maple.dto.CartDTO;
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
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @Test
    public void saveCart() {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setStockId(6);
        cartDTO.setQuanlity(5);
        System.out.println(cartService.saveCart(cartDTO, 1));
    }

    @Test
    public void deleteCart() {
        System.out.println(cartService.deleteCart(2, 1));
    }

    @Test
    public void updateCart() {
        System.out.println(cartService.updateCart(1, 2, 3));
    }

    @Test
    public void listCart() {
        List<CartItemDTO> cartItemDTOS = cartService.listCart(1);
        for (CartItemDTO c : cartItemDTOS) {
            System.out.println(c.toString());
        }
    }

    @Test
    public void testValidateCart() {
        System.out.println(cartService.validateSaveCart(6,12));
    }
}