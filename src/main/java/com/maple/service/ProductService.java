package com.maple.service;

import com.maple.dto.ProductDTO;
import com.maple.dto.ProductItemDTO;

import java.util.List;

public interface ProductService {

    /**
     * 获取商品列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProductItemDTO> listProduct(Integer pageNum, Integer pageSize);

    /**
     * 分类浏览
     *
     * @param typeName
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProductItemDTO> listProductByTypeName(String typeName, Integer pageNum, Integer pageSize);

    /**
     * 搜索浏览
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProductItemDTO> listProductBySearch(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 商品详情
     *
     * @param productNum
     * @return
     */
    ProductDTO getProduct(String productNum);
}
