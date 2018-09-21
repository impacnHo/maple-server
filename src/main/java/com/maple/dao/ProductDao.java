package com.maple.dao;

import com.maple.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductDao {

    /**
     * 获取商品详情
     *
     * @param productNum
     * @reutrn
     */
    @Select("SELECT product_num,name,sub_name,lanch_date,descr,price " +
            "FROM product " +
            "WHERE product_num = #{productNum}")
    @Results({
            @Result(property = "productNum", column = "product_num"),
            @Result(property = "subName", column = "sub_name"),
            @Result(property = "lanchDate", column = "lanch_date")
    })
    Product getProduct(@Param("productNum") String productNum);

    /**
     * 获取商品列表
     *
     * @return
     */
    @Select("SELECT product_num AS productNum,name,sub_name AS subName,price,lanch_date AS lanchDate FROM product AS p")
    List<Product> listProduct();

    /**
     * 分类浏览
     *
     * @param typeName
     * @return
     */
    @Select("SELECT product_num AS productNum,p.name,sub_name AS subName,price,lanch_date AS lanchDate " +
            "FROM product as p,product_type as pt " +
            "WHERE p.type_id = pt.id AND pt.name = #{typeName}")
    List<Product> listProductByTypeName(@Param("typeName") String typeName);


    /**
     * 搜索商品
     *
     * @param keyword
     * @return
     */
    @Select("SELECT product_num AS productNum,p.name,sub_name AS subName,price,lanch_date AS lanchDate " +
            "FROM product as p,brand as b " +
            "WHERE p.brand_id = b.id AND (p.name LIKE #{keyword} " +
            "OR p.sub_name LIKE #{keyword} " +
            "OR p.product_num LIKE #{keyword} " +
            "OR b.name LIKE #{keyword})")
    List<Product> listProductBySearch(@Param("keyword") String keyword);

    /**
     * 通过库存id查商品价格
     *
     * @param stockId
     * @return
     */
    @Select("SELECT price " +
            "FROM product AS p,stock AS s " +
            "WHERE s.product_id = p.id AND s.id = #{stockId}")
    BigDecimal getPriceByStockId(@Param("stockId") Integer stockId);


}
