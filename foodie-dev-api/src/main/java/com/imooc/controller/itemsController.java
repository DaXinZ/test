package com.imooc.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.pojo.*;
import com.imooc.pojo.vo.IteminfoVo;
import com.imooc.service.ItemService;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.StringRandom;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date: 2023/3/27 4:04 下午
 * HelloController
 * Describe：
 */
@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class itemsController {
     @Autowired
     private ItemService itemService;


    final  static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(
            @ApiParam(name = "itemId",value =  "商品id",required = true)
            @PathVariable String itemId){
        StringRandom treceid = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(treceid.getStringRandom());

        logger.info(
           "接收参数" +    JSON.toJSONString(itemId)
        );
        if (StringUtils.isBlank(itemId)){
            logger.info(JSON.toJSONString(itemId));
            return IMOOCJSONResult.errorMsg("id为空");
        }

        Items item = itemService.queryItemById(itemId);
        List<ItemsImg> itemImg = itemService.queryItemsImg(itemId);
        List<ItemsSpec> itemSpecs = itemService.queryItemsSpec(itemId);
        ItemsParam itemParam =  itemService.queryItemsParam(itemId);

        IteminfoVo iteminfoVo = new IteminfoVo();
        iteminfoVo.setItem(item);
        iteminfoVo.setItemsImgList(itemImg);
        iteminfoVo.setItemSpecsList(itemSpecs);
        iteminfoVo.setItemParam(itemParam);


        String itemvo =  JSON.toJSONString(iteminfoVo);
        String Item = JSON.toJSONString(item);
        String Itemimg = JSON.toJSONString(itemImg);
        String ItemSpe = JSON.toJSONString(itemSpecs);
        String ItemPara = JSON.toJSONString(itemParam);

        logger.info( JSON.toJSONString("item数据"+ Item)
                + "\t" +
                JSON.toJSONString("itemImg数据"+Itemimg)
                + "\t" +
                JSON.toJSONString("itemSpecs数据"+ItemSpe)
                + "\t" +
                JSON.toJSONString("itemParam数据" + ItemPara)
                       + "新数据"  + item.toString()
                );


        logger.info( JSON.toJSONString("新数据"+ itemvo));
        return IMOOCJSONResult.ok(iteminfoVo);
    }


}