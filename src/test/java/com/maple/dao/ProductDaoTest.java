package com.maple.dao;

import com.maple.dto.ProductItemDTO;
import com.maple.entity.Product;
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
public class ProductDaoTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void getProduct() throws Exception {
        Product product = productDao.getProduct("142334");
        System.out.println(product.toString());
    }

    @Test
    public void listProduct() throws Exception {
        List<Product> list = new ArrayList<>();
        list = productDao.listProduct();
        System.out.println("===Size: " + list.size() + "===");
        for (Product p : list) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testsearch() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList = productDao.listProductByTypeName("鞋履");
        for (Product p : productList) {
            System.out.println(p.toString());
        }
        System.out.println("size: " + productList.size());
    }

    @Test
    public void priceTest() throws Exception {
        System.out.println(productDao.getPriceByStockId(5).getClass());
    }

    @Test
    public void testtype() throws Exception {
        List<Product> products = productDao.listProductByTypeName("鞋履");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    @Test
    public void testSearch() throws Exception {
        String keyword = "%nike%";
        List<Product> products = productDao.listProductBySearch(keyword);
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}