package com.imooc.controller;

import bo.UserBo;
import com.imooc.service.UserService;

import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.StringRandom;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



    /**
     *  查询用户名接口
     * @param username
     * @return
     */
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String username) {
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom(25));

        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空",imoocjsonResult.setTrceid(test.getStringRandom(25)));
        }

        // 2. 查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已存在",imoocjsonResult.setTrceid(test.getStringRandom(25)));
        }

        // 3. 请求成功，用户名没有重复
        return IMOOCJSONResult.ok(username,imoocjsonResult.setTrceid(test.getStringRandom(25)));
    }


    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBo userBo) {
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom(25));

      String username = userBo.getUsername();
      String password = userBo.getPassword();
      String confirmpassword = userBo.getCofirmPassword();
        // 判断用户名和密码必须不为空
       if (StringUtils.isBlank(username) ||
               StringUtils.isBlank(password) ||
               StringUtils.isBlank(confirmpassword)
       ){
           return IMOOCJSONResult.errorMsg("用户名或密码不能为空",imoocjsonResult.setTrceid(test.getStringRandom(25)));
       }

        // 查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已存在",imoocjsonResult.setTrceid(test.getStringRandom(25)));
        }

        //密码长度不能少于6位
        if (password.length() < 6 ){
            return IMOOCJSONResult.errorMsg("密码长度不能少于6",imoocjsonResult.setTrceid(test.getStringRandom(25)));
        }

        //判断两次密码不一致
        if (!password.equals(confirmpassword)  ){
            return IMOOCJSONResult.errorMsg("两次密码不一致",imoocjsonResult.setTrceid(test.getStringRandom(25)));
        }
        // 实现注册功能
        userService.createUser(userBo);

        // 3. 请求成功，用户名没有重复
        return IMOOCJSONResult.ok("注册成功，用户名为" + username ,imoocjsonResult.setTrceid(test.getStringRandom(25)) );
    }




    }


