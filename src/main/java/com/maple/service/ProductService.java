package com.maple.service;

import com.maple.dto.ProductDTO;
import com.maple.dto.ProductItemDTO;

import java.util.List;

public interface ProductService {

    /**
     * 获取商品列表
     *
     * @return
     */
    List<ProductItemDTO> listProduct();

    /**
     * 分类浏览
     *
     * @param typeName
     * @return
     */
    List<ProductItemDTO> listProductByTypeName(String typeName);

    /**
     * 搜索浏览
     *
     * @param keyword
     * @return
     */
    List<ProductItemDTO> listProductBySearch(String keyword);

    /**
     * 商品详情
     *
     * @param productNum
     * @return
     */
    ProductDTO getProduct(String productNum);
}
