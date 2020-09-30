package com.web.onlineforumapi;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@SpringBootApplication(scanBasePackages = "com.web")
@MapperScan("com.web.onlineforumapi.dao")
public class OnlineForumApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineForumApiApplication.class, args);
    }

}
