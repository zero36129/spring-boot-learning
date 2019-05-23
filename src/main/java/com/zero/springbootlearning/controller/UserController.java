package com.zero.springbootlearning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.springbootlearning.model.User;

@RestController()
public class UserController {

    @RequestMapping("/user/getUser")
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("kobe");
        return user;
    }

}
