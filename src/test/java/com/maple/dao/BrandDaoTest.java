package com.maple.dao;

import com.maple.entity.Brand;
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
public class BrandDaoTest {
    @Autowired
    BrandDao brandDao;

    @Test
    public void test() throws Exception {
        List<Brand> brandList = new ArrayList<>();
        brandList = brandDao.listBrand();
        for (Brand brand : brandList) {
            System.out.println(brand.toString());
        }
    }

    @Test
    public void testxx() throws Exception {
        Brand brand = new Brand();
        System.out.println(brand.toString());
        brand = brandDao.getBrandByProductNum("142334");
        System.out.println(brand.toString());
    }

    @Test
    public void test2() throws Exception {
        Brand brand = new Brand();
        brand.setName("1a11a1a1a1a1");
        brandDao.saveBrand(brand);
        System.out.println("generated id: " + brand.getId());
    }

    @Test
    public void test3() throws Exception {
        System.out.println("result: " + brandDao.updateBrand(30, "QNMBQ"));
    }

    @Test
    public void test4() throws Exception {
        Brand brand = brandDao.getBrand(33);
        System.out.println(brand.toString());
    }

}