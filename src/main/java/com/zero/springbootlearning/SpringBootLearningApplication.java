package com.zero.springbootlearning;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
//@ServletComponentScan
//@EnableCaching
@EnableScheduling
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }

}
