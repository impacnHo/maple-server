package com.maple.service;

import com.maple.dto.UserConsigneeDTO;
import com.maple.dto.UserInfoDTO;
import com.maple.dto.UserRegistryDTO;
import com.maple.entity.UserRegistry;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveUserRegistry() {
        UserRegistryDTO userRegistry = new UserRegistryDTO();
        userRegistry.setUsername("test82");
        userRegistry.setPwd("owd");
        System.out.println(userService.saveUserRegistry(userRegistry));
    }

    @Test
    public void updatePwd() {
        System.out.println(userService.updatePwd(12, "ne11111wpass"));
    }

    @Test
    public void updateUserInfo() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(1);
        userInfoDTO.setName("qaq");
        userInfoDTO.setLocation("广州");
        userInfoDTO.setSex(true);
        userInfoDTO.setBirth(new Date());
        System.out.println(userService.updateUserInfo(userInfoDTO));
    }

    @Test
    public void saveUserConsignee() {
        UserConsigneeDTO userConsigneeDTO = new UserConsigneeDTO();
        userConsigneeDTO.setUserId(1);
        userConsigneeDTO.setName("张三");
        userConsigneeDTO.setTel("13102259363");
        userConsigneeDTO.setAddress("gdsfsssdqxxxx");
        System.out.println(userService.saveUserConsignee(userConsigneeDTO));
    }

    @Test
    public void updateUserConsignee() {
        UserConsigneeDTO userConsigneeDTO = new UserConsigneeDTO();
        userConsigneeDTO.setId(2);
        userConsigneeDTO.setName("nmsl");
        userConsigneeDTO.setTel("13102259363");
        userConsigneeDTO.setAddress("gdsfsssdqxxxx");
        System.out.println(userService.updateUserConsignee(userConsigneeDTO));
    }

    @Test
    public void validateUsnFormat() {
        System.out.println(userService.validateUsnFormat("lmp/"));
    }

    @Test
    public void validatePwdLength() {
        System.out.println(userService.validatePwdLength("nmslnmslnmslnmslnmslm"));
    }

    @Test
    public void isUsnExist() {
        System.out.println(userService.isUsnExist("nmsl"));
    }

}