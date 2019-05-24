package com.zero.springbootlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.springbootlearning.model.user.User;
import com.zero.springbootlearning.service.user.UserService;

@RestController()
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/user/getUser")
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("kobe");
        return user;
    }

    @RequestMapping("/findUserById")
    public User findUserById(Integer id) {
        User user = userService.findUserById(1);
        return user;
    }

}
