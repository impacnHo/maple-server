package com.maple.controller;

import com.maple.dto.UserRegistryDTO;
import com.maple.service.UserRegistryService;
import com.maple.util.result.Result;
import com.maple.util.result.ResultTemplate;
import com.maple.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/userRegistry")
public class UserRegistryController {
    @Autowired
    private UserRegistryService userRegistryService;

    /**
     * 用户注册
     *
     * @param userRegistryDTO
     * @return
     */
    @PostMapping("/register")
    public Result userRegister(@RequestBody UserRegistryDTO userRegistryDTO) {
        String username = userRegistryDTO.getUsername();
        String pwd = userRegistryDTO.getPwd();
        if (!userRegistryService.validateUsnFormat(username))
            return ResultTemplate.getFailResult("用户名长度错误或包含非数字英文");
        if (!userRegistryService.validatePwdLength(pwd))
            return ResultTemplate.getFailResult("密码长度错误");
        if (userRegistryService.isUsnExist(username))
            return ResultTemplate.getFailResult("用户名已被注册");
        userRegistryService.saveUserRegistry(userRegistryDTO);
        return ResultTemplate.getSuccessResult("注册成功", null);
    }

    /**
     * 用户登录
     *
     * @param userRegistryDTO
     * @return
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody UserRegistryDTO userRegistryDTO) {
        if (!userRegistryService.isUsnExist(userRegistryDTO.getUsername()))
            return ResultTemplate.getFailResult("用户名不存在");
        int uid = userRegistryService.validatePwd(userRegistryDTO.getUsername(), userRegistryDTO.getPwd());
        if (uid != 0) {
            return ResultTemplate.getSuccessResult(TokenUtil.createToken(uid));
        } else {
            return ResultTemplate.getFailResult("用户名或密码输入错误");
        }
    }

}
