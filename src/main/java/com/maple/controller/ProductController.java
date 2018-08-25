package com.maple.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.maple.dto.ProductDTO;
import com.maple.dto.ProductItemDTO;
import com.maple.service.ProductService;
import com.maple.util.result.Result;
import com.maple.util.result.ResultTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public Result listProduct(@RequestParam(defaultValue = "1") int page) {
        Page pageInfo = PageHelper.startPage(page, 12);
        List<ProductItemDTO> productItemDTOList = productService.listProduct();
        return ResultTemplate.getSuccessResult(pageInfo.getPages(), productItemDTOList);
    }

    @GetMapping("/product/{typeName}")
    public Result listProductByTypeName(@PathVariable String typeName, @RequestParam(defaultValue = "1") int page) {
        Page pageInfo = PageHelper.startPage(page, 12);
        List<ProductItemDTO> productItemDTOList = productService.listProductByTypeName(typeName);
        return ResultTemplate.getSuccessResult(pageInfo.getPages(), productItemDTOList);
    }

    @GetMapping("/product/p/{productNum}")
    public Result getProduct(@PathVariable String productNum) {
        ProductDTO productDTO = productService.getProduct(productNum);
        return ResultTemplate.getSuccessResult(productDTO);
    }

    @GetMapping("/search")
    public Result listProductBySearch(@RequestParam String keyword, @RequestParam(defaultValue = "1") int page) {
        Page pageInfo = PageHelper.startPage(page, 12);
        List<ProductItemDTO> productItemDTOList = productService.listProductBySearch(keyword);
        return ResultTemplate.getSuccessResult(pageInfo.getPages(), productItemDTOList);
    }
}
