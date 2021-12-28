package com.imooc.controller;

import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Date: 2021/9/27 10:55 上午
 * StuFooController
 * Describe：
 */
@ApiIgnore
@RestController
public class StuFooController {

    @Autowired
    private StuService stuService;
    @GetMapping("/getStu")
    public Object hello(int id){
        return stuService.getStuinfo(id);
    }
}
