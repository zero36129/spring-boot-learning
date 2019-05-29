package com.zero.springbootlearning.dao2.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zero.springbootlearning.model.user.UserTest2;

//@Mapper
public interface UserTest2Dao {

//    UserTest2 findUserById(int id);
    
    @Select("SELECT * FROM user_test2 WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "address", column = "address")
    })
    UserTest2 findUserById(int id);

}
