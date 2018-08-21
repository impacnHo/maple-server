package com.maple.dao;

import com.maple.entity.UserRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistryDaoTest {
    @Autowired
    private UserRegistryDao userRegistryDao;

    @Test
    public void saveUserRegistry() {
        UserRegistry userRegistry = new UserRegistry();
        userRegistry.setUsername("sungou");
        userRegistry.setPwd("sungou");
        userRegistryDao.saveUserRegistry(userRegistry);
    }

    @Test
    public void updatePwd() {
        userRegistryDao.updatePwd(10,"newpassword");
    }
}