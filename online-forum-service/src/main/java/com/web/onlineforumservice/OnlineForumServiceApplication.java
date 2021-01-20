package com.web.onlineforumservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OnlineForumServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineForumServiceApplication.class, args);
    }

}
