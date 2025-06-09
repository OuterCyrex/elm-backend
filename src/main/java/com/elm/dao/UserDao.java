package com.elm.dao;

import com.elm.model.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Insert("INSERT INTO user (userId, password, userName, userSex, userImg, delTag) " +
            "VALUES (#{userId}, #{password}, #{userName}, #{userSex}, #{userImg}, #{delTag})")
    int insertUser(User user);

    @Select({
            "<script>",
            "SELECT * FROM user WHERE delTag = 0",
            "<if test='userId != null and userId != \"\"'>AND userId = #{userId}</if>",
            "<if test='password != null and password != \"\"'>AND password = #{password}</if>",
            "<if test='userName != null and userName != \"\"'>AND userName = #{userName}</if>",
            "<if test='userSex != null'>AND userSex = #{userSex}</if>",
            "<if test='userImg != null and userImg != \"\"'>AND userImg = #{userImg}</if>",
            "</script>"
    })
    List<User> findUser(User user);
}
