package com.maple.controller;


import com.auth0.jwt.interfaces.Claim;
import com.maple.dto.UserInfoDTO;
import com.maple.service.UserInfoService;
import com.maple.service.UserRegistryService;
import com.maple.util.result.Result;
import com.maple.util.result.ResultTemplate;
import com.maple.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/")
    public Result getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        int userId = claims.get("uid").asInt();
        return ResultTemplate.getSuccessResult(userInfoService.getUserInfo(userId));
    }

    @PatchMapping("/")
    public Result updateUserInfo(HttpServletRequest request, @RequestBody UserInfoDTO userInfoDTO) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int uid = claims.get("uid").asInt();
            userInfoDTO.setId(uid);
            return ResultTemplate.getSuccessResult(userInfoService.updateUserInfo(userInfoDTO));
        } else {
            return ResultTemplate.getFailResult("身份验证失败");
        }

    }
}
