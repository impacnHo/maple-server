package com.maple.controller;

import com.auth0.jwt.interfaces.Claim;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.maple.dto.OrderDTO;
import com.maple.service.OrderService;
import com.maple.util.result.Result;
import com.maple.util.result.ResultCode;
import com.maple.util.result.ResultTemplate;
import com.maple.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Result saveOrder(HttpServletRequest request, @RequestParam("cartIds[]") int[] cartIds, @RequestParam("userConsigneeId") Integer userConsigneeId) {
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
    public Result listOrder(HttpServletRequest request, @RequestParam(defaultValue = "1") int page) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            Page pageInfo = PageHelper.startPage(page, 12);
            List<OrderDTO> orderDTOList = orderService.listOrder(userId);
            return ResultTemplate.getSuccessResult(String.valueOf(pageInfo.getPages()), orderDTOList);
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @GetMapping("/{id}")
    public Result getOrder(HttpServletRequest request, @PathVariable("id") Integer id) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(orderService.getOrderDetial(id, userId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @PatchMapping("/{id}")
    public Result payForOrder(HttpServletRequest request, @PathVariable("id") Integer id, @RequestParam("payment") Integer payment, @RequestParam("account") String account) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(orderService.payForOrder(id, userId, payment, account));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @DeleteMapping("/{id}")
    public Result cancelOrder(HttpServletRequest request, @PathVariable("id") Integer id) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if(null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(orderService.cancelOrder(id, userId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }
}
