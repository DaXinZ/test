package com.imooc.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Date: 2021/9/24 4:04 下午
 * Application
 * Describe：
 */


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = "com.imooc")
@SpringBootApplication(scanBasePackages = "com.imooc")
@MapperScan(basePackages = "com.imooc.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
