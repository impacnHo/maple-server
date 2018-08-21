package com.maple.service;

import com.maple.dto.ProductDTO;
import com.maple.dto.ProductItemDTO;
import com.maple.dto.StockDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    public void listProduct() {
        List<ProductItemDTO> productItemDTOList = new ArrayList<>();
        productItemDTOList = productService.listProduct(1, 12);
        for (ProductItemDTO p : productItemDTOList) {
            System.out.println(p.toString());
        }
        System.out.println("===size: " + productItemDTOList.size() + "===");
    }

    @Test
    public void getProduct() {
        ProductDTO productDTO = productService.getProduct("142334");
        List<StockDTO> stockDTOList = productDTO.getSotcks();
        System.out.println(productDTO.toString());
        for (StockDTO s : stockDTOList) {
            System.out.println(s.toString());
        }
    }

    @Test
    public void listPoroductByTypeName() throws Exception {
        List<ProductItemDTO> productItemDTOList = productService.listProductByTypeName("鞋履", 1, 12);
        for (ProductItemDTO p : productItemDTOList) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void listPoroductBySearch() throws Exception {
        List<ProductItemDTO> productItemDTOList = productService.listProductBySearch("nike", 1, 12);
        for (ProductItemDTO p : productItemDTOList) {
            System.out.println(p.toString());
        }
        System.out.println("size: " + productItemDTOList.size());
    }
}