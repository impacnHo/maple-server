package com.maple.service.impl;

import com.maple.dao.UserInfoDao;
import com.maple.dto.UserInfoDTO;
import com.maple.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void getUserInfo() {
        UserInfoDTO userInfoDTO = userInfoService.getUserInfo(1);
        System.out.println(userInfoDTO.toString());
    }

    @Test
    public void updateUserInfo() {
        UserInfoDTO userInfoDTO = userInfoService.getUserInfo(1);
        userInfoDTO.setName("孙笑川");
        userInfoDTO.setId(1);
        System.out.println(userInfoService.updateUserInfo(userInfoDTO));
    }
}