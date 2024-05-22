package com.imooc.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.enums.YesOrNo1;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.Users;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.pojo.vo.UsersVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.service.UserService;
import com.imooc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


@Api(value = "用户接口", tags = {"用户相关信息的查询修改接口"})
@RestController
@RequestMapping("User")
public class UsersController  {
    @Autowired
    private UserService userService;

    final  static Logger logger = LoggerFactory.getLogger(UsersController.class);


    /**
     *
     * @param uid
     * @return  根据用户uid查询用户相关信息
     */

    @ApiOperation(value = "查询用户相关信息", notes = "查询用户相关信息", httpMethod = "GET")
    @GetMapping("/queryUser.json/{uid}")
    public IMOOCJSONResult queryUser(
            @ApiParam(name = "uid", value = "用户uid", required = false
                     )
            @RequestParam String uid ) {

        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());
        logger.info("接受用户请求参数"+ JSON.toJSONString(uid));
        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(uid)) {
            logger.info("查询失败用户名为空"+ JSON.toJSONString(uid));
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        // 2. 查找注册的用户名是否存在
        List<UsersVO> list = userService.queryUsers(uid);


         logger.info("查询成功返回参数如下" + JSON.toJSONString(list));
        return IMOOCJSONResult.ok(list);
    }

    /**
     *
     * @param nikename
     * @return  根据用户昵称查询相关信息
     */

   @ApiOperation(value = "使用用户昵称查询相关信息",notes = "用户昵称",httpMethod = "GET")
    @GetMapping("/queryUsernikename.json/{nikename}")
    public IMOOCJSONResult  queryname(
            @ApiParam(name = "nikename",value = "用户昵称",required = false
              )@RequestParam String nikename) {
       logger.info("接受入参"+JSON.toJSONString(nikename));
       StringRandom test = new StringRandom();
       IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
       imoocjsonResult.setTrceid(test.getStringRandom());
       String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());
   if (StringUtils.isBlank(nikename))
   {
       logger.info("用户名为空"+JSON.toJSONString(nikename));
       return IMOOCJSONResult.errorMsg("用户名不能为空");
   }

   List<UsersVO> list = userService.queryUsername(nikename);
       logger.info("请求成功返回参数如下"+JSON.toJSONString(list));

   return IMOOCJSONResult.ok(list);
   }


    @ApiOperation(value = "新整合用户查询接口",notes = "用户昵称",httpMethod = "POST")
    @PostMapping("/queryUser.json")
    public IMOOCJSONResult getsuer(
            @ApiParam(name = "Id",value =  "用户id",required = false)
            @RequestParam String Id,

            @ApiParam(name = "nickname",value =  "用户昵称",required = false)
            @RequestParam String nickname,

            @ApiParam(name = "username",value =  "用户名称",required = false)
            @RequestParam String username,

            @ApiParam(name = "sex",value =  "年龄",required = false)
            @RequestParam Integer sex,

            @ApiParam(name = "sort",value =  "查询方式",required = true)
            @RequestParam String sort)

    {


        logger.info("接受入参"+JSON.toJSONString(Id+nickname+username+sex+sort));
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());
        if (StringUtils.isBlank(sort))
        {
            logger.info("查询方式为空"+JSON.toJSONString(sort));
            return IMOOCJSONResult.errorMsg("查询方式不能为空");
        }

        List<UsersVO> list = userService.queryUsertow(Id,nickname,username,sex,sort);
        logger.info("请求成功返回参数如下"+JSON.toJSONString(list));

        return IMOOCJSONResult.ok(list);
    }


    @ApiOperation(value = "修改用户密码",notes = "修改密码",httpMethod = "POST")
    @PostMapping("/updatepassword.json")
    public IMOOCJSONResult updatepassword(
            @ApiParam(name = "id",value =  "用户id",required = false)
            @RequestParam String id,
            @ApiParam(name = "newpassword",value =  "新密码",required = false)
            @RequestParam String newpassword,
            @ApiParam(name = "password",value =  "确认密码",required = false)
            @RequestParam String password,
            @ApiParam(name = "formerpassword",value =  "原有密码",required = false)
            @RequestParam String formerpassword)


    {
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());
        logger.info("接受入参"+JSON.toJSONString(id+password+newpassword));
        if (StringUtils.isBlank(id)){
            logger.info(JSON.toJSONString(id+"不能为空"));
            return IMOOCJSONResult.ok("id为空");

        }
        UsersVO usersVO = new UsersVO();
        usersVO.setPassword(password);
        usersVO.setNewpassword(newpassword);
        usersVO.setFormerpassword(formerpassword);
        String pass = usersVO.getPassword();
        String newpass = usersVO.getNewpassword();
        String forem = usersVO.getFormerpassword();
        isAlphaNumeric isAlphaNumeric = new isAlphaNumeric();

        if (!isAlphaNumeric.isAlphaNumeric(pass)){
            logger.info("密码必须包含字母和数字");
            return IMOOCJSONResult.ok("密码必须包含字母和数字");
        };

        if (pass.length() < 6 || pass.length() > 16){
            logger.info("密码长度为6-16位");
            return IMOOCJSONResult.ok("密码长度为6-16位");
        }

        if (!pass.equals(newpass)){
            logger.info("两次输入密码不一致");
            return IMOOCJSONResult.ok("两次输入密码不一致");
        }

        if (StringUtils.isBlank(password) ||  StringUtils.isBlank(newpassword)  || StringUtils.isBlank(formerpassword)){
            logger.info(JSON.toJSONString("新密码和原有密码不能为空"));
        }
        try {
            usersVO.setPassword(MD5Utils.getMD5Str(usersVO.getPassword()));
            usersVO.setFormerpassword(MD5Utils.getMD5Str(usersVO.getFormerpassword()));
            usersVO.setNewpassword(MD5Utils.getMD5Str(usersVO.getNewpassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String pass1 = usersVO.getPassword();
        String passnew = usersVO.getNewpassword();

        UsersVO  Oldpassword   = userService.querypassword(id);
        String   formernew = Oldpassword.getPassword();
        logger.info(JSON.toJSONString(Oldpassword));
        String former = usersVO.getFormerpassword();


        if (!formernew.equals(former)){
            logger.info(JSON.toJSONString(pass1+former));
            return  IMOOCJSONResult.ok("新密码和原有密码不一致，请检查密码");
        }
        if (passnew.equals(formernew)){
            logger.info(JSON.toJSONString("新密码不能和原密码一致"));
            return IMOOCJSONResult.ok("新密码不能和原密码一致");
        }
        Date updatedtime  = usersVO.getUpdatedTime(usersVO.setUpdatedTime(new Date()));
        logger.info(JSON.toJSONString(updatedtime));
        boolean new1 =  userService.updetepassword(id,pass1,updatedtime);
         JSON.toJSONString("修改密码成功，新密码为"+pass1+"修改时间"+updatedtime);
        return IMOOCJSONResult.ok(new1);
        }

    @ApiOperation(value = "查询用户密码",notes = "查询密码",httpMethod = "POST")
    @PostMapping("/querypassword.json")
    public IMOOCJSONResult updatepassword(
            @ApiParam(name = "id",value =  "用户id",required = false)
            @RequestParam String id)
        {
            logger.info("接受入参"+JSON.toJSONString(id));
            UsersVO  Oldpassword =  userService.querypassword(id);

         return IMOOCJSONResult.ok(Oldpassword);
         }








}
