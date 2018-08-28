package com.maple.service.impl;

import com.maple.dao.UserConsigneeDao;
import com.maple.dto.UserConsigneeDTO;
import com.maple.entity.UserConsignee;
import com.maple.service.UserConsigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userConsigneeService")
public class UserConsigneeServiceImpl implements UserConsigneeService {
    @Autowired
    private UserConsigneeDao userConsigneeDao;

    @Override
    public UserConsigneeDTO getUserConsignee(Integer id) {
        UserConsignee userConsignee =  userConsigneeDao.getUserConsignee(id);
        UserConsigneeDTO userConsigneeDTO = new UserConsigneeDTO();
        userConsigneeDTO.setId(userConsignee.getId());
        userConsigneeDTO.setName(userConsignee.getName());
        userConsigneeDTO.setAddress(userConsignee.getAddress());
        userConsigneeDTO.setTel(userConsignee.getTel());
        return userConsigneeDTO;
    }

    @Override
    public List<UserConsigneeDTO> listUserConsignee(Integer userId) {
        List<UserConsignee> userConsigneeList = userConsigneeDao.listUserConsignee(userId);
        List<UserConsigneeDTO> userConsigneeDTOList = new ArrayList<UserConsigneeDTO>();
        UserConsigneeDTO userConsigneeDTO;
        for (UserConsignee userConsignee : userConsigneeList) {
            userConsigneeDTO = new UserConsigneeDTO();
            userConsigneeDTO.setId(userConsignee.getId());
            userConsigneeDTO.setName(userConsignee.getName());
            userConsigneeDTO.setAddress(userConsignee.getAddress());
            userConsigneeDTO.setTel(userConsignee.getTel());
            userConsigneeDTOList.add(userConsigneeDTO);
        }
        return userConsigneeDTOList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveUserConsignee(UserConsigneeDTO userConsigneeDTO) {
        UserConsignee userConsignee = new UserConsignee(userConsigneeDTO.getUserId(), userConsigneeDTO.getName(), userConsigneeDTO.getTel(), userConsigneeDTO.getAddress());
        userConsigneeDao.saveUserConsignee(userConsignee);
        int ucid = userConsignee.getId();
        return ucid;
    }

    @Transactional
    @Override
    public boolean updateUserConsignee(UserConsigneeDTO userConsigneeDTO, Integer userId) {
        UserConsignee userConsignee = new UserConsignee();
        userConsignee.setId(userConsigneeDTO.getId());
        userConsignee.setUserId(userId);
        userConsignee.setAddress(userConsigneeDTO.getAddress());
        userConsignee.setName(userConsigneeDTO.getName());
        userConsignee.setTel(userConsigneeDTO.getTel());
        return userConsigneeDao.updateUserConsignee(userConsignee) != null;
    }

    @Transactional
    @Override
    public boolean deleteUserConsignee(Integer id, Integer userId) {
        return userConsigneeDao.deleteUserConsignee(id, userId) != null;
    }

}
