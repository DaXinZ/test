package com.imooc.controller;

import com.imooc.enums.YesOrNo1;
import com.imooc.pojo.Carousel;
import com.imooc.service.CarouselService;
import com.imooc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    final  static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel(){
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());
       List<Carousel> list =  carouselService.queryAll(YesOrNo1.YES.type);
        logger.info(trceid +  "\t 轮播图查询成功" );
        return IMOOCJSONResult.ok(list);
    }


}