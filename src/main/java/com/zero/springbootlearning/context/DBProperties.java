package com.zero.springbootlearning.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:database.properties")
public class DBProperties {

    @Value("${spring.datasource.url}")
    public String url;
    @Value("${spring.datasource.username}")
    public String username;
    @Value("${spring.datasource.pw}")
    public String pw;
    @Value("${spring.datasource.driver-class-name}")
    public String driverClassName;

}
