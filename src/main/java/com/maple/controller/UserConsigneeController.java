package com.maple.controller;

import com.auth0.jwt.interfaces.Claim;
import com.maple.dto.UserConsigneeDTO;
import com.maple.service.UserConsigneeService;
import com.maple.util.result.Result;
import com.maple.util.result.ResultCode;
import com.maple.util.result.ResultTemplate;
import com.maple.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/userConsignee")
public class UserConsigneeController {
    @Autowired
    private UserConsigneeService userConsigneeService;

    @GetMapping("/")
    public Result listUserConsignee(HttpServletRequest request) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(userConsigneeService.listUserConsignee(userId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @PostMapping("/")
    public Result saveUserConsignee(HttpServletRequest request, @RequestBody UserConsigneeDTO userConsigneeDTO) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            // 验证
            if(!userConsigneeService.validateNameLength(userConsigneeDTO.getName()))
                return ResultTemplate.getFailResult("姓名长度错误");
            if(!userConsigneeService.validateAddressLength(userConsigneeDTO.getAddress()))
                return ResultTemplate.getFailResult("地址长度错误");
            if(!userConsigneeService.validateTelFormat(userConsigneeDTO.getTel()))
                return ResultTemplate.getFailResult("联系电话长度或格式错误");

            int userId = claims.get("uid").asInt();
            userConsigneeDTO.setUserId(userId);
            return ResultTemplate.getSuccessResult(userConsigneeService.saveUserConsignee(userConsigneeDTO));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @PatchMapping("/")
    public Result updateUserCosignee(HttpServletRequest request, @RequestBody UserConsigneeDTO userConsigneeDTO) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(userConsigneeService.updateUserConsignee(userConsigneeDTO, userId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @DeleteMapping("/{id}")
    public Result deleteUserConsignee(HttpServletRequest request, @PathVariable Integer id) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(userConsigneeService.deleteUserConsignee(id, userId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }
}
