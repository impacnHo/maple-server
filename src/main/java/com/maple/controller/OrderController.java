package com.maple.controller;

import com.auth0.jwt.interfaces.Claim;
import com.maple.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Result saveOrder(HttpServletRequest request, @RequestParam("cartIds") int[] cartIds, @RequestParam("userConsigneeId") Integer userConsigneeId) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(orderService.saveOrder(userId, cartIds, userConsigneeId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @GetMapping("/")
    public Result listOrder(HttpServletRequest request) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(orderService.listOrder(userId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }
}
