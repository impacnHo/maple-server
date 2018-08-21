package com.maple.dao;

import com.maple.entity.UserConsignee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

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
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer saveUserConsignee(UserConsignee userConsignee);

    /**
     * 更新用户收货地址
     *
     * @param userConsignee
     * @return
     */
    @Update("UPDATE user_consignee " +
            "SET name = #{name},tel = #{tel},address = #{address},gmt_modified = now() " +
            "WHERE id = #{id}")
    Integer updateUserConsignee(UserConsignee userConsignee);

    /**
     * 获取用户地址信息
     *
     * @param id
     * @return
     */
    @Select("SELECT name,tel,address FROM user_consignee WHERE id = #{id}")
    UserConsignee getUserConsignee(@Param("id") Integer id);
}
