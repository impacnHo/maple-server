package com.maple.service;

import com.maple.dto.UserInfoDTO;

public interface UserInfoService {
    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    UserInfoDTO getUserInfo(Integer id);

    /**
     * 更新用户信息
     *
     * @param userInfoDTO
     * @return
     */
    boolean updateUserInfo(UserInfoDTO userInfoDTO);
}
