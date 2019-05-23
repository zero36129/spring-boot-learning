package com.zero.springbootlearning.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyProperties {

    @Value("${com.zero.title}")
    public String title;
    @Value("${com.zero.description}")
    public String description;

}
