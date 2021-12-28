package com.imooc.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Date: 2021/9/22 4:04 下午
 * HelloController
 * Describe：
 */
@ApiIgnore
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Object hello(){
        return "SpringBoot 运行成功~~5";
    }
}