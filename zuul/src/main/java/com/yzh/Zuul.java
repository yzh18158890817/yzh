package com.yzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yzh
 * @date 2019/8/8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Zuul {
    public static void main(String[] args) {
        SpringApplication.run(Zuul.class);
    }
}
