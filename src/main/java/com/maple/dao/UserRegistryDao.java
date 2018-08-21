package com.maple.dao;

import com.maple.entity.UserRegistry;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistryDao {

    /**
     * 保存用户
     *
     * @param userRegistry
     * @return
     */
    @Insert("INSERT INTO user_registry(username,pwd,gmt_create,gmt_modified) VALUES(#{username},#{pwd},now(),now())")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer saveUserRegistry(UserRegistry userRegistry);

    /**
     * 根据id和新密码更新用户密码
     *
     * @param id
     * @param pwd
     * @return
     */
    @Update("UPDATE user_registry " +
            "SET pwd = #{newPwd},gmt_modified = now() " +
            "WHERE id = #{id}")
    Integer updatePwd(@Param("id") Integer id, @Param("newPwd") String pwd);
}
