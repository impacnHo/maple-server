package com.maple.service;

import com.maple.dao.BrandDao;
import com.maple.dto.BrandDTO;
import com.maple.entity.Brand;
import com.maple.service.impl.BrandServiceImpl;
import org.junit.Before;
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
public class BrandServiceTest {
    @Autowired
    BrandService brandService;


    @Test
    public void listBrand() {
        List<BrandDTO> list = new ArrayList<>();
        list = brandService.listBrand();
        for (BrandDTO b : list) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void saveBrand() {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName("123411");
        System.out.println("new id: " + brandService.saveBrand(brandDTO));
    }

    @Test
    public void getBrand() {
        BrandDTO brandDTO = brandService.getBrand(39);
        System.out.println(brandDTO.toString());
    }

    @Test
    public void updateBrand() {
        System.out.println("result:" + brandService.updateBrand(33, "test"));
    }
}