package com.imooc.controller;

import bo.UserBo;
import com.imooc.enums.YesOrNo1;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Users;
import com.imooc.service.CarouselService;
import com.imooc.service.UserService;

import com.imooc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Date: 2021/9/22 4:04 下午
 * HelloController
 * Describe：
 */
@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {
     @Autowired
     private CarouselService carouselService;


    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel(){
       List<Carousel> list =  carouselService.queryAll(YesOrNo1.YES.type);

        return IMOOCJSONResult.ok();
    }


}