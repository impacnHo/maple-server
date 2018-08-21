package com.maple.dao;

import com.maple.entity.Stock;
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
public class StockDaoTest {
    @Autowired
    private StockDao stockDao;

    @Test
    public void listStock() throws Exception {
        List<Stock> stocks = new ArrayList<>();
        stocks = stockDao.listStock("142334");
        for (Stock s : stocks) {
            System.out.println(s.toString());
        }
    }
}