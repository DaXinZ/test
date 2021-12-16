package com.imooc.controller;

import com.imooc.service.StuService;
import com.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2021/9/27 10:55 上午
 * StuFooController
 * Describe：
 */

@RestController
@RequestMapping("paasport")
public class PassportController {

    @Autowired
    private UserService userService;
    @GetMapping("/usernameIsExist")
    public  int usernameIsExist(@RequestParam  String  username){
        return username;
    }

}
