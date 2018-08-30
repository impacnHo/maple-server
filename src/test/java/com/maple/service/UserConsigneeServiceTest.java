package com.maple.service;

import com.maple.dao.UserConsigneeDao;
import com.maple.dto.UserConsigneeDTO;
import com.maple.entity.UserConsignee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserConsigneeServiceTest {
    @Autowired
    private UserConsigneeService userConsigneeService;

    @Test
    public void getUserConsignee() {
        UserConsigneeDTO userConsigneeDTO = userConsigneeService.getUserConsignee(4);
        System.out.println(userConsigneeDTO.toString());
    }

    @Test
    public void listUserConsignee() {
        List<UserConsigneeDTO> userConsigneeDTOList = userConsigneeService.listUserConsignee(1);
        for(UserConsigneeDTO userConsigneeDTO : userConsigneeDTOList) {
            System.out.println(userConsigneeDTO.toString());
        }
    }

    @Test
    public void saveUserConsignee() {
        UserConsigneeDTO userConsigneeDTO = new UserConsigneeDTO();
        userConsigneeDTO.setUserId(1);
        userConsigneeDTO.setName("李老八");
        userConsigneeDTO.setAddress("四川成都");
        userConsigneeDTO.setTel("13122245789");
        System.out.println(userConsigneeService.saveUserConsignee(userConsigneeDTO));
    }

    @Test
    public void updateUserConsignee() {
        UserConsigneeDTO userConsigneeDTO = userConsigneeService.getUserConsignee(5);
        userConsigneeDTO.setAddress("火星");
        System.out.println(userConsigneeService.updateUserConsignee(userConsigneeDTO,1));
    }

    @Test
    public void deleteUserConsignee() {
        System.out.println(userConsigneeService.deleteUserConsignee(5,1));
    }

    @Test
    public void testName() {
        System.out.println(userConsigneeService.validateNameLength("五呜呜呜无"));
    }

    @Test
    public void testTel() {
        System.out.println(userConsigneeService.validateTelFormat(""));
    }

}