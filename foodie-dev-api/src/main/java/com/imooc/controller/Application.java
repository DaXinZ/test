package com.imooc.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Date: 2021/9/24 4:04 下午
 * Application
 * Describe：
 */



@SpringBootApplication(scanBasePackages = "com.imooc")
@MapperScan(basePackages = "com.imooc.mapper")
//扫描所有包，以及相关组件包
@ComponentScan(basePackages =  {"com.imooc","org.n3r.idworker"})
@ComponentScan("config")
//开启定时任务
@EnableScheduling

public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
