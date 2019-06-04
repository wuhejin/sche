package com.sandystar.scheduleadmin.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sandystar.scheduleadmin.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao extends BaseMapper<User> {

    User getUser(@Param("name") String name);

}
