package com.imooc.controller;

import bo.UserBo;
import com.imooc.pojo.Users;
import com.imooc.service.UserService;

import com.imooc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 2021/9/27 10:55 上午
 * StuFooController
 * Describe：
 */
@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;



    /**
     *  查询用户名接口
     * @param username
     * @return
     */
    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String username) {
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());

        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        // 2. 查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }

        // 3. 请求成功，用户名没有重复
        return IMOOCJSONResult.ok();
    }

    /**
     *
     * @param userBo
     * @return  用户注册
     */
    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBo userBo, HttpServletRequest request,
                                  HttpServletResponse response) {
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());

      String username = userBo.getUsername();
      String password = userBo.getPassword();
      String confirmpassword = userBo.getConfirmPassword();
        // 判断用户名和密码必须不为空
       if (StringUtils.isBlank(username)){
           return IMOOCJSONResult.errorMsg("用户名为空");
       }
        if (StringUtils.isBlank(password)){
            return IMOOCJSONResult.errorMsg("密码为空");
        }
        if (StringUtils.isBlank(confirmpassword)){
            return IMOOCJSONResult.errorMsg("确认密码为空");
        }

        // 查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }

        //密码长度不能少于6位
        if (password.length() < 6 ){
            return IMOOCJSONResult.errorMsg("密码长度不能少于6");
        }

        //判断两次密码不一致
        if (!password.equals(confirmpassword)  ){
            return IMOOCJSONResult.errorMsg("两次密码不一致");
        }
        // 实现注册功能
        Users userResult =   userService.createUser(userBo);

         userResult = setNullProperty(userResult);
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        // 3. 请求成功，用户名没有重复
        return IMOOCJSONResult.ok("注册成功，用户名为" + username  );
    }


    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "post")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody UserBo userBo ,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());

      String username = userBo.getUsername();
      String password = userBo.getPassword();
        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //判断密码不能为空
        if (StringUtils.isBlank(password)){
            return IMOOCJSONResult.errorMsg("密码不能为空");
        }
        //密码长度不能少于6位
        if (password.length() < 6){
            return IMOOCJSONResult.errorMsg("密码长度少于6位");
        }


        //实现登录
        Users userResult = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));

        //判断用户名和密码是否正确
        if(userResult == null ){
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }

        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);

        userResult = setNullProperty(userResult);
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);
        // 3. 登录成功
        return IMOOCJSONResult.ok("登录成功");
    }
       private Users setNullProperty(Users userResult){
           userResult.setPassword(null);
           userResult.setMobile(null);
           userResult.setEmail(null);
           userResult.setCreatedTime(null);
           userResult.setUpdatedTime(null);
           userResult.setBirthday(null);
           return userResult;
       }
    }


