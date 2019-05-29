package com.zero.springbootlearning.dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zero.springbootlearning.model.user.User;

//@Mapper
public interface UserDao {

//    User findUserById(int id);
    
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name")
    })
    User findUserById(int id);

}
