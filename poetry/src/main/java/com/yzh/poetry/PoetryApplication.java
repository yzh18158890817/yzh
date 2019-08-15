package com.yzh.poetry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yzh
 * @date 2019/8/15
 */
@SpringBootApplication
@MapperScan("com.yzh.poetry.mapper")
public class PoetryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoetryApplication.class);
    }
}
