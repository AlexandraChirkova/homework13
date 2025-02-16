package com.example.postcoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PostCoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostCoreApiApplication.class, args);
    }

}
