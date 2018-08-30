package com.maple.service.impl;

import com.maple.dao.UserConsigneeDao;
import com.maple.dao.UserInfoDao;
import com.maple.dao.UserRegistryDao;
import com.maple.dto.UserConsigneeDTO;
import com.maple.dto.UserInfoDTO;
import com.maple.dto.UserRegistryDTO;
import com.maple.entity.UserConsignee;
import com.maple.entity.UserInfo;
import com.maple.entity.UserRegistry;
import com.maple.service.UserRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserRegistryServiceImpl implements UserRegistryService {
    @Autowired
    private UserRegistryDao userRegistryDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserConsigneeDao userConsigneeDao;

    @Override
    public boolean validateUsnFormat(String username) {
        return username.matches("[0-9A-Za-z]*") && username.length() >= 3 && username.length() <= 10;
    }

    @Override
    public boolean validatePwdLength(String pwd) {
        return pwd.length() >= 10 && pwd.length() <= 20;
    }

    @Override
    public boolean isUsnExist(String username) {
        String result = userRegistryDao.getUsername(username);
        if ("".equals(result) || null == result) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveUserRegistry(UserRegistryDTO userRegistryDTO) {
        // save user registry
        UserRegistry userRegistry = new UserRegistry(userRegistryDTO.getUsername(), userRegistryDTO.getPwd());
        userRegistryDao.saveUserRegistry(userRegistry);
        int uid = userRegistry.getId();

        // save user info
        UserInfo userInfo = new UserInfo();
        userInfo.setId(uid);
        userInfoDao.saveUserInfo(userInfo);
        return uid;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePwd(Integer id, String newPwd) {
        return userRegistryDao.updatePwd(id, newPwd) != null;
    }


    @Override
    public Integer validatePwd(String username, String pwd) {
        UserRegistry userRegistry = userRegistryDao.getPwdByUsername(username);
        return pwd.equals(userRegistry.getPwd()) ? userRegistry.getId() : 0;
    }

    @Override
    public String getPwd(Integer id) {
        return userRegistryDao.getPwdById(id);
    }
}
