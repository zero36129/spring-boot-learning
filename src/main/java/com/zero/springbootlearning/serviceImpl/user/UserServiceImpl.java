package com.zero.springbootlearning.serviceImpl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.springbootlearning.dao.user.UserDao;
import com.zero.springbootlearning.model.user.User;
import com.zero.springbootlearning.service.user.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

}
