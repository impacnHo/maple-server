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
import com.maple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
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
    public boolean updateUserInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo(userInfoDTO.getId(), userInfoDTO.getName(), userInfoDTO.isSex(), userInfoDTO.getBirth(), userInfoDTO.getLocation());
        return userInfoDao.updateUserInfo(userInfo) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveUserConsignee(UserConsigneeDTO userConsigneeDTO) {
        UserConsignee userConsignee = new UserConsignee(userConsigneeDTO.getUserId(), userConsigneeDTO.getName(), userConsigneeDTO.getTel(), userConsigneeDTO.getAddress());
        userConsigneeDao.saveUserConsignee(userConsignee);
        int ucid = userConsignee.getId();
        return ucid;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUserConsignee(UserConsigneeDTO userConsigneeDTO) {
        UserConsignee userConsignee = new UserConsignee(userConsigneeDTO.getUserId(), userConsigneeDTO.getName(), userConsigneeDTO.getTel(), userConsigneeDTO.getAddress());
        userConsignee.setId(userConsigneeDTO.getId());
        return userConsigneeDao.updateUserConsignee(userConsignee) != null;
    }

    @Override
    public Integer validatePwd(String username, String pwd) {
        UserRegistry userRegistry = userRegistryDao.getPwdByUsername(username);
        return pwd.equals(userRegistry.getPwd()) ? userRegistry.getId() : 0;
    }
}
