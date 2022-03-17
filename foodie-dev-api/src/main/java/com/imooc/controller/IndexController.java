package com.imooc.controller;

import com.imooc.enums.YesOrNo1;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
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
    @Autowired
    private CategoryService categoryService;

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

    /**
     * 首页分类展示需求：
     * 1.第一次刷新主页查询大分类，渲染展示到首页
     * 2.如果鼠标上移到大分类，则加载其子分类内容，如果存在子分类，则不需要加载（懒加载）
     */

    @ApiOperation(value = "获取商品分类（一级分类）", notes = "获取商品分类（一级分类）", httpMethod = "GET")
    @GetMapping("/cats")
    public IMOOCJSONResult cats(){
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());

        List<Category> list =  categoryService.queryAllRootLevelCat();
        logger.info(trceid +  "\t 一级分类查询成功" );
        return IMOOCJSONResult.ok(list);
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatid}")
    public IMOOCJSONResult subCat(
            @ApiParam(name = "rootCatid",value =  "一级分类id",required = true)
            @PathVariable Integer rootCatid){
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());
        if (rootCatid == null ){
            logger.info(trceid +  "\t id为空" );
            return IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<CategoryVO> list = categoryService.getSubCatList(rootCatid);

        logger.info(trceid +  "\t 子分类查询成功" );
        return IMOOCJSONResult.ok(list);
    }
}