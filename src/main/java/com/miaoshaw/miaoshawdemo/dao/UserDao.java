package com.miaoshaw.miaoshawdemo.dao;

import com.miaoshaw.miaoshawdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    
    @Select("select * from user where id=#{id}")
    List <User> getById(@Param("id")int id);
}
