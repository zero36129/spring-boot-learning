package com.zero.springbootlearning.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.zero.springbootlearning.model.user.User;

@Mapper
public interface UserDao {

    User findUserById(int id);

}
