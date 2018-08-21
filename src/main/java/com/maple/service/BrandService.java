package com.maple.service;

import com.maple.dto.BrandDTO;
import com.maple.entity.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 获取品牌列表
     */
    List<BrandDTO> listBrand();

    /**
     * 获取品牌
     *
     * @param id
     * @return BrandDTO
     */
    BrandDTO getBrand(Integer id);

    /**
     * 保存品牌
     *
     * @param brandDTO
     * @return id
     */
    Integer saveBrand(BrandDTO brandDTO);

    /**
     * 更新品牌名称
     *
     * @param id
     * @param name
     * @return 影响条数
     */
    boolean updateBrand(Integer id, String name);

}
