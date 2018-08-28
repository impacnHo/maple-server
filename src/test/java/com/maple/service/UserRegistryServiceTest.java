package com.maple.service;

import com.maple.dto.UserConsigneeDTO;
import com.maple.dto.UserInfoDTO;
import com.maple.dto.UserRegistryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistryServiceTest {
    @Autowired
    private UserRegistryService userRegistryService;

    @Test
    public void saveUserRegistry() {
        UserRegistryDTO userRegistry = new UserRegistryDTO();
        userRegistry.setUsername("test82");
        userRegistry.setPwd("owd");
        System.out.println(userRegistryService.saveUserRegistry(userRegistry));
    }

    @Test
    public void updatePwd() {
        System.out.println(userRegistryService.updatePwd(12, "ne11111wpass"));
    }

//    @Test
//    public void updateUserInfo() {
//        UserInfoDTO userInfoDTO = new UserInfoDTO();
//        userInfoDTO.setId(1);
//        userInfoDTO.setName("qaq");
//        userInfoDTO.setLocation("广州");
//        userInfoDTO.setSex(true);
//        userInfoDTO.setBirth(new Date());
//        System.out.println(userRegistryService.updateUserInfo(userInfoDTO));
//    }

//    @Test
//    public void saveUserConsignee() {
//        UserConsigneeDTO userConsigneeDTO = new UserConsigneeDTO();
//        userConsigneeDTO.setUserId(1);
//        userConsigneeDTO.setName("张三");
//        userConsigneeDTO.setTel("13102259363");
//        userConsigneeDTO.setAddress("gdsfsssdqxxxx");
//        System.out.println(userRegistryService.saveUserConsignee(userConsigneeDTO));
//    }
//
//    @Test
//    public void updateUserConsignee() {
//        UserConsigneeDTO userConsigneeDTO = new UserConsigneeDTO();
//        userConsigneeDTO.setId(2);
//        userConsigneeDTO.setName("nmsl");
//        userConsigneeDTO.setTel("13102259363");
//        userConsigneeDTO.setAddress("gdsfsssdqxxxx");
//        System.out.println(userRegistryService.updateUserConsignee(userConsigneeDTO));
//    }

    @Test
    public void validateUsnFormat() {
        System.out.println(userRegistryService.validateUsnFormat("lmp/"));
    }

    @Test
    public void validatePwdLength() {
        System.out.println(userRegistryService.validatePwdLength("nmslnmslnmslnmslnmslm"));
    }

    @Test
    public void isUsnExist() {
        System.out.println(userRegistryService.isUsnExist("nmsl"));
    }

    @Test
    public void validatePwd() {
        System.out.println(userRegistryService.validatePwd("kiko","kiko123"));
    }
}