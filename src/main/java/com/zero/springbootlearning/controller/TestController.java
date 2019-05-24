package com.zero.springbootlearning.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.springbootlearning.context.DBProperties;
import com.zero.springbootlearning.context.MyProperties;
import com.zero.springbootlearning.utils.ModelUtils;

@RestController
public class TestController {

    @Autowired
    private MyProperties myProperties;
    @Autowired
    private DBProperties dbProperties;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!!";
    }

    @RequestMapping("/getProperties")
    public Map<String, Object> getProperties() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> modelMap = new HashMap<>();
        modelMap = ModelUtils.getKeyAndValue(myProperties);
        for (Map.Entry<String, Object> m : modelMap.entrySet()) {
            System.out.println("key:" + m.getKey() + " value:" + m.getValue());
            map.put(m.getKey(), m.getValue());
        }
        return map;
    }
    
    @RequestMapping("/db")
    public String getDB() {
        return dbProperties.url;
    }

}
