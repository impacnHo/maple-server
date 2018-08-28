package com.maple.dao;

import com.maple.dto.UserInfoDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoDaoTest {
    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void saveUserInfo() {
    }

    @Test
    public void updateUserInfo() {
    }

    @Test
    public void getUserInfo() {
        UserInfoDTO userInfoDTO = userInfoDao.getUserInfo(1);
        System.out.println(userInfoDTO.toString());
    }
}