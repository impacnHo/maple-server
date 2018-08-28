package com.maple.dao;

import com.maple.entity.UserConsignee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserConsigneeDaoTest {
    @Autowired
    private UserConsigneeDao userConsigneeDao;

    @Test
    public void saveUserConsignee() {
        UserConsignee userConsignee = new UserConsignee();
        userConsignee.setUserId(1);
        userConsignee.setName("孙笑川");
        userConsignee.setTel("13123345433");
        userConsignee.setAddress("广东省。。。");
        System.out.println(userConsigneeDao.saveUserConsignee(userConsignee));
    }

    @Test
    public void updateUserConsignee() {
        UserConsignee userConsignee = userConsigneeDao.getUserConsignee(3);
        userConsignee.setAddress("qaqqqqq");
        userConsignee.setUserId(1);
        System.out.println(userConsignee.toString());
        System.out.println(userConsigneeDao.updateUserConsignee(userConsignee));
    }

    @Test
    public void listUserConsignee() {
        List<UserConsignee> userConsigneeList = userConsigneeDao.listUserConsignee(1);
        for(UserConsignee userConsignee : userConsigneeList) {
            System.out.println(userConsignee.toString());
        }
    }

    @Test
    public void deleteUserConsignee() {
        System.out.println(userConsigneeDao.deleteUserConsignee(3,1));
    }

    @Test
    public void getUserConsignee() {
        UserConsignee userConsignee = userConsigneeDao.getUserConsignee(4);
        System.out.println(userConsignee.toString());
    }
}