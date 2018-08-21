package com.maple.dao;

import com.maple.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {

    /**
     * 保存用户信息
     *
     * @param userInfo
     * @return
     */
    @Insert("INSERT INTO user_info(id,name,sex,birth,location,gmt_create,gmt_modified) " +
            "VALUES(#{id},#{name},#{sex},#{birth},#{location},now(),now())")
    void saveUserInfo(UserInfo userInfo);

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return
     */
    @Update("UPDATE user_info " +
            "SET name = #{name},sex = #{sex},birth = #{birth},location = #{location},gmt_modified = now() " +
            "WHERE id = #{id}")
    Integer updateUserInfo(UserInfo userInfo);
}
