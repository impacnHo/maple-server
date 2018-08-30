package com.maple.service;

import com.maple.dto.UserConsigneeDTO;
import com.maple.entity.UserConsignee;

import java.util.List;

public interface UserConsigneeService {

    /**
     * 获取单个用户地址
     *
     * @param id
     * @return
     */
    UserConsigneeDTO getUserConsignee(Integer id);

    /**
     * 获取用户地址列表
     *
     * @param userId
     * @return
     */
    List<UserConsigneeDTO> listUserConsignee(Integer userId);

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
    boolean updateUserConsignee(UserConsigneeDTO userConsigneeDTO, Integer userId);

    /**
     * 删除用户地址
     *
     * @param id
     * @param userId
     * @return
     */
    boolean deleteUserConsignee(Integer id, Integer userId);

    /**
     * 验证姓名长度
     * @param name
     * @return
     */
    boolean validateNameLength(String name);

    /**
     * 验证地址长度
     * @param address
     * @return
     */
    boolean validateAddressLength(String address);

    /**
     * 验证电话号码格式
     * @param tel
     * @return
     */
    boolean validateTelFormat(String tel);


}
