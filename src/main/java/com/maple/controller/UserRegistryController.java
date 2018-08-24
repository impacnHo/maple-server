package com.maple.controller;

import com.maple.dto.UserRegistryDTO;
import com.maple.service.UserService;
import com.maple.util.Result;
import com.maple.util.ResultTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRegistryController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result validateUserRegistey(@RequestBody UserRegistryDTO userRegistryDTO) {
        String username = userRegistryDTO.getUsername();
        String pwd = userRegistryDTO.getPwd();
        if(!userService.validateUsnFormat(username))
            return ResultTemplate.getFailResult("用户名长度错误或包含非数字英文");
        if(!userService.validatePwdLength(pwd))
            return ResultTemplate.getFailResult("密码长度错误");
        if(userService.isUsnExist(username))
            return ResultTemplate.getFailResult("用户名已被注册");
        userService.saveUserRegistry(userRegistryDTO);
        return ResultTemplate.getSuccessResult("注册成功",null);
    }
}
