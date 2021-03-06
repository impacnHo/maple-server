package com.maple.controller;

import com.maple.dto.UserRegistryDTO;
import com.maple.service.UserRegistryService;
import com.maple.util.token.TokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistryControllerTest {
    @Autowired
    private UserRegistryService userRegistryService;

    @Test
    public void test() {
        UserRegistryDTO userRegistryDTO = new UserRegistryDTO();
        userRegistryDTO.setUsername("kiko");
        userRegistryDTO.setPwd("kiko123");
        if (!userRegistryService.isUsnExist(userRegistryDTO.getUsername()))
            System.out.println("用户名不存在");
        int uid = userRegistryService.validatePwd(userRegistryDTO.getUsername(), userRegistryDTO.getPwd());
        if (uid != 0) {
            System.out.println(TokenUtil.createToken(uid));
        } else {
            System.out.println("用户名或密码输入错误");
        }
    }
}
