package com.maple.service.impl;

import com.maple.dao.UserInfoDao;
import com.maple.dto.UserInfoDTO;
import com.maple.entity.UserInfo;
import com.maple.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfoDTO getUserInfo(Integer id) {
        return userInfoDao.getUserInfo(id);
    }

    @Transactional
    @Override
    public boolean updateUserInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo(userInfoDTO.getId(), userInfoDTO.getName(), userInfoDTO.isSex(), userInfoDTO.getBirth(), userInfoDTO.getLocation());
        return userInfoDao.updateUserInfo(userInfo) != null;
    }
}
