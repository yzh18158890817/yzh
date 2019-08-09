package com.yzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yzh
 * @date 2019/8/8
 */
@SpringBootApplication
@EnableEurekaServer
public class Registry {
    public static void main(String[] args) {
        SpringApplication.run(Registry.class);
    }
}
