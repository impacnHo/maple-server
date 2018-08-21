package com.maple.dao;

import com.maple.entity.Brand;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDao {

    /**
     * 获取品牌列表
     */
    @Select("SELECT id,name FROM brand")
    List<Brand> listBrand();

    /**
     * 根据id获取品牌
     *
     * @param id
     * @return Brand
     */
    @Select("SELECT id,name FROM brand WHERE id = #{id}")
    Brand getBrand(@Param("id") Integer id);


    /**
     * 根据货号获取品牌
     *
     * @param productNum
     * @return
     */
    @Select("SELECT b.name " +
            "FROM brand as b,product as p " +
            "WHERE b.id = p.brand_id AND p.product_num = #{productNum}")
    Brand getBrandByProductNum(@Param("productNum") String productNum);

    /**
     * 保存品牌信息
     *
     * @param brand
     * @return 品牌id
     */
    @Insert("INSERT INTO brand(name,gmt_create,gmt_modified) VALUES (#{name},now(),now())")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer saveBrand(Brand brand);

    /**
     * 修改品牌名称
     *
     * @param id
     * @param name
     * @return 影响条数
     */
    @Update("UPDATE brand SET name = #{name},gmt_modified = now() WHERE id = #{id}")
    Integer updateBrand(@Param("id") Integer id, @Param("name") String name);

}
