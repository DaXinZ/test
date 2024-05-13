package com.imooc.controller;

import bo.UserBo;
import com.alibaba.fastjson.JSON;
import com.imooc.pojo.Users;
import com.imooc.pojo.vo.UsersVO;
import com.imooc.service.UserService;
import com.imooc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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

    final  static Logger logger = LoggerFactory.getLogger(HelloController.class);

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
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());

        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            logger.info(trceid +  "\t 用户名不能为空");
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        // 2. 查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            logger.info(trceid +  "\t 用户名已存在");
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }

        // 3. 请求成功，用户名没有重复
        logger.info(trceid +  "\t ok");
        return IMOOCJSONResult.ok();
    }

    /**
     *  查询用户名接口
     * @param nikename
     * @return
     */
    @ApiOperation(value = "用户昵称是否存在", notes = "用户昵称是否存在", httpMethod = "GET")
    @GetMapping("/usernikenameIsExist")
    public IMOOCJSONResult usernikenameIsExist(@RequestParam String nikename) {
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());

        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());

        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(nikename)) {
            logger.info(trceid +  "\t 用户名不能为空");
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        // 2. 查找注册的用户名是否存在
        boolean isExist = userService.queryUsernikenameIsExist(nikename);
        if (isExist) {

            logger.info(trceid +  "\t 用户名已存在");

            return IMOOCJSONResult.errorMsg("用户名已存在");
        }

        // 3. 请求成功，用户名没有重复
        logger.info(trceid +  "\t ok");
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
       String  trceid  =  imoocjsonResult.setTrceid(test.getStringRandom());
       RandomNickname randomNickname = new RandomNickname();
      String username = userBo.getUsername();
      String password = userBo.getPassword();
      String confirmpassword = userBo.getConfirmPassword();
      String nickname = userBo.getNickname();

      //判断用户名是否为空，为空则塞入随机数
      if (StringUtils.isBlank(nickname)){
          userBo.setNickname(randomNickname.RandomScale());


      }
        String  nickname2 = userBo.getNickname();

      //查询用户名
        List<UsersVO>  queryname =  userService.queryUsername(nickname2);
        logger.info("查询用户呢称返回的数据 "+JSON.toJSONString(queryname));
        JSONArray jsonArray = new JSONArray(queryname);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String nickName = jsonObject.getString("nickName");
            logger.info("取值出来的数据"+ nickName);
            if (nickname2.equals(nickName)){
                 logger.info(JSON.toJSONString("当前名字已存在，请修改"+nickName));
                 return  IMOOCJSONResult.errorMsg("用户昵称已存在");
            }
        }


        // 判断用户名和密码必须不为空
       if (StringUtils.isBlank(username)){
           logger.info(trceid +  "\t 用户名为空");
           return IMOOCJSONResult.errorMsg("用户名为空");

       }
        if (StringUtils.isBlank(password)){
            logger.info(trceid +  "\t 密码为空");
            return IMOOCJSONResult.errorMsg("密码为空");
        }
        if (StringUtils.isBlank(confirmpassword)){
            logger.info(trceid +  "\t 确认密码为空");
            return IMOOCJSONResult.errorMsg("确认密码为空");
        }

        // 查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            logger.info(JSON.toJSONString("用户名已存在" + username));
            return IMOOCJSONResult.errorMsg("用户名已存在");

        }

        //密码长度不能少于6位
        if (password.length() < 6 || password.length() > 16){
            logger.info("密码长度为6-16位");
        }

        //判断两次密码不一致
        if (!password.equals(confirmpassword)  ){
            logger.info(trceid +  "\t 两次密码不一致");
            return IMOOCJSONResult.errorMsg("两次密码不一致");
        }

        // 实现注册功能
        Users userResult =   userService.createUser(userBo);

         userResult = setNullProperty(userResult);
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        // 3. 请求成功，用户名没有重复
        logger.info(JSON.toJSONString(userResult));
        return IMOOCJSONResult.ok("注册成功用户名为"+username+"昵称为" + nickname2);
    }

    /**
     *
     * @param userBo
     * @param request
     * @param response
     * @return  用户登录接口
     * @throws Exception
     */
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody UserBo userBo ,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  =  imoocjsonResult.setTrceid(test.getStringRandom());

      String username = userBo.getUsername();
      String password = userBo.getPassword();
        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            logger.info(trceid + userBo +   IMOOCJSONResult.errorMsg("用户名不能为空"));
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //判断密码不能为空
        if (StringUtils.isBlank(password)){
            logger.info(trceid +  "\t 密码不能为空");
            return IMOOCJSONResult.errorMsg("密码不能为空");
        }
        //密码长度不能少于6位
        if (password.length() < 6){
            logger.info(trceid +  "\t 密码长度少于6位");
            return IMOOCJSONResult.errorMsg("密码长度少于6位");
        }


        //实现登录
        Users userResult = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));

        //判断用户名和密码是否正确
        if(userResult == null ){
            logger.info(trceid +  "\t 用户名或密码不正确");
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
        logger.info(trceid +  "\t 登录成功");
        return IMOOCJSONResult.ok("登录成功");
    }
       private Users setNullProperty(Users userResult){
           // TODO 设置那些字段不让前端知道，并且设置为空
           userResult.setPassword(null);
           userResult.setMobile(null);
           userResult.setEmail(null);
           userResult.setCreatedTime(null);
           userResult.setUpdatedTime(null);
           userResult.setBirthday(null);
           return userResult;
       }

     /**
     *
     * @param userId
     * @param request
     * @param response
     * @return 退出登录
     */
    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public  IMOOCJSONResult logout(@RequestParam String userId,
                                   HttpServletRequest request,
                                   HttpServletResponse response){
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  =  imoocjsonResult.setTrceid(test.getStringRandom());


        // 2. 查找用户id是否存在
        boolean isExist = userService.queryUserIdIsExist(userId);
        if (isExist) {
            logger.info(trceid +  "\t 当前id不存在");
            return IMOOCJSONResult.errorMsg("当前id不存在");
        }

         //清楚用户的相关信息
        CookieUtils.deleteCookie(request,response,"user");
        // TODO 用户退出登录需要清空购物车
        // TODO 分布式会话中需要清楚用户数据
        logger.info(trceid +" \t 退出登录成功");
        return IMOOCJSONResult.ok(userId);
    }

}


