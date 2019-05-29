package com.zero.springbootlearning.serviceImpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.springbootlearning.dao.user.UserDao;
import com.zero.springbootlearning.dao2.user.UserTest2Dao;
import com.zero.springbootlearning.model.user.User;
import com.zero.springbootlearning.model.user.UserTest2;
import com.zero.springbootlearning.service.user.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserTest2Dao userTest2Dao;

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    public UserTest2 findUser2ById(int id) {
        return userTest2Dao.findUserById(id);
    }

}
