package com.maple.dao;

import com.maple.entity.UserConsignee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Repository
public interface UserConsigneeDao {

    /**
     * 保存用户收货地址
     *
     * @param userConsignee
     * @return
     */
    @Insert("INSERT INTO user_consignee(user_id,name,tel,address,gmt_create,gmt_modified) " +
            "VALUES(#{userId},#{name},#{tel},#{address},now(),now())")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Integer saveUserConsignee(UserConsignee userConsignee);

    /**
     * 更新用户收货地址
     *
     * @param userConsignee
     * @return
     */
    @Update("UPDATE user_consignee " +
            "SET name = #{name},tel = #{tel},address = #{address},gmt_modified = now() " +
            "WHERE id = #{id} AND user_id = #{userId}")
    Integer updateUserConsignee(UserConsignee userConsignee);

    /**
     * 获取单个用户地址信息
     *
     * @param id
     * @return
     */
    @Select("SELECT id,name,tel,address FROM user_consignee WHERE id = #{id}")
    UserConsignee getUserConsignee(@Param("id") Integer id);

    /**
     * 获取用户地址列表
     *
     * @param id
     * @return
     */
    @Select("SELECT id,name,tel,address FROM user_consignee WHERE user_id = #{id}")
    List<UserConsignee> listUserConsignee(@Param("id") Integer id);

    /**
     * 通过id和用户id删除地址
     *
     * @param id
     * @param uid
     * @return
     */
    @Delete("DELETE FROM user_consignee WHERE id = #{id} AND user_id = #{uid}")
    Integer deleteUserConsignee(@Param(("id")) Integer id, @Param("uid") Integer uid);
}
