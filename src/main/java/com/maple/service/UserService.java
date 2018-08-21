package com.maple.service;

import com.maple.dto.UserConsigneeDTO;
import com.maple.dto.UserInfoDTO;
import com.maple.dto.UserRegistryDTO;
import com.maple.entity.UserConsignee;
import com.maple.entity.UserRegistry;

public interface UserService {

    /**
     * 保存用户注册记录并新增用户信息
     *
     * @param userRegistryDTO
     * @return
     */
    Integer saveUserRegistry(UserRegistryDTO userRegistryDTO);

    /**
     * 更新用户登录密码
     *
     * @param id
     * @param newPwd
     * @return
     */
    boolean updatePwd(Integer id, String newPwd);

    /**
     * 更新用户信息
     *
     * @param userInfoDTO
     * @return
     */
    boolean updateUserInfo(UserInfoDTO userInfoDTO);

    /**
     * 保存用户收货地址
     *
     * @param userConsigneeDTO
     * @return
     */
    Integer saveUserConsignee(UserConsigneeDTO userConsigneeDTO);

    /**
     * 更新用户收货地址
     *
     * @param userConsigneeDTO
     * @return
     */
    boolean updateUserConsignee(UserConsigneeDTO userConsigneeDTO);
}