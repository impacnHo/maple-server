package com.maple.controller;

import com.auth0.jwt.interfaces.Claim;
import com.maple.dto.CartDTO;
import com.maple.service.CartService;
import com.maple.util.result.Result;
import com.maple.util.result.ResultCode;
import com.maple.util.result.ResultTemplate;
import com.maple.util.token.TokenUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public Result listCart(HttpServletRequest request) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(cartService.listCart(userId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @PostMapping("/")
    public Result saveCart(HttpServletRequest request, @RequestBody CartDTO cartDTO) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            int id = cartService.saveCart(cartDTO, userId);
            if(0 == id) {
                return ResultTemplate.getFailResult("请求数量错误，请重试");
            } else {
                return ResultTemplate.getSuccessResult(String.valueOf(id));
            }
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @PatchMapping("/")
    public Result updateCart(HttpServletRequest request, @RequestBody CartDTO cartDTO) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(cartService.updateCart(cartDTO.getStockId(), userId, cartDTO.getQuanlity()));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }

    @DeleteMapping("/{id}")
    public Result deleteCart(HttpServletRequest request, @PathVariable Integer id) {
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int userId = claims.get("uid").asInt();
            return ResultTemplate.getSuccessResult(cartService.deleteCart(id, userId));
        } else {
            return ResultTemplate.getFreeResult(ResultCode.UNAUTHORIZED, "认证失败", null);
        }
    }
}
