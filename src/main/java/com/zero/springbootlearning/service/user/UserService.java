package com.zero.springbootlearning.service.user;

import java.util.List;

import com.zero.springbootlearning.model.user.User;
import com.zero.springbootlearning.model.user.UserTest2;

public interface UserService {

    User findUserById(int id);

    UserTest2 findUser2ById(int id);

}
