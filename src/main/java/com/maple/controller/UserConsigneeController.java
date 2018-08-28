package com.maple.controller;

import com.maple.dto.UserConsigneeDTO;
import com.maple.entity.UserConsignee;
import com.maple.util.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/userConsignee")
public class UserConsigneeController {
    @GetMapping("/")
    public Result listUserConsignee(HttpServletRequest request) {
        return null;
    }

    @PostMapping("/")
    public Result saveUserConsignee(HttpServletRequest request,@RequestBody UserConsigneeDTO userConsigneeDTO) {
        return null;
    }

    @PatchMapping("/")
    public Result updateUserCosignee(HttpServletRequest request, @RequestBody UserConsigneeDTO userConsigneeDTO) {
        return null;
    }

    @DeleteMapping("/")
    public Result deleteUserConsignee(HttpServletRequest request,@RequestBody Integer id) {
        return null;
    }
}
