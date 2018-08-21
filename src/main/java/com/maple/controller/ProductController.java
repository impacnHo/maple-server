package com.maple.controller;

import com.maple.service.ProductService;
import com.maple.util.Result;
import com.maple.util.ResultTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public Result listProduct(@RequestParam(defaultValue = "1") int page) {
        return ResultTemplate.getSuccessResult(productService.listProduct(page, 12));
    }

    @GetMapping("/product/{typeName}")
    public Result listProductByTypeName(@PathVariable String typeName, @RequestParam(defaultValue = "1") int page) {
        System.out.println("controller: " + typeName + " " + page);
        return ResultTemplate.getSuccessResult(productService.listProductByTypeName(typeName, page, 12));
    }
}
