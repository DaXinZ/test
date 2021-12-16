package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2021/9/22 4:04 下午
 * HelloController
 * Describe：
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Object hello(){
        return "SpringBoot 运行成功~~3";
    }
}