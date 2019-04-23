package com.mj.mall.test.hsql;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select  id,username,password,phone,email,create_time,update_time,open_id from mb_user where id =#{userId}")
    UserEntity findByID(@Param("userId") Integer userId);

    @Insert("INSERT  INTO `mb_user` (username,password,phone,email,create_time,update_time,open_id) VALUES (#{username}, #{password},#{phone},#{email},#{createTime},#{updateTime},#{openId});")
    Integer insertUser(UserEntity userEntity);

    @Select("select  id,username,password,phone,email,create_time,update_time,open_id from mb_user where username=#{username} and password=#{password}")
    UserEntity login(@Param("username") String username, @Param("password") String password);
}
