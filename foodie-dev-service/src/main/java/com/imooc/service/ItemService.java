package com.imooc.service;

import com.imooc.pojo.*;
import com.imooc.pojo.vo.CommentLevelCommensVo;
import com.imooc.pojo.vo.commodityVo;

import java.util.List;

/**
 * Date: 2022/3/15 2:20 下午
 * CarouseLService
 * Describe：
 */
public interface ItemService {

    /**
     * 根据商品id查询商品详情
     * @param itemId
     * @return
     */
    public Items queryItemById(String id);

    /**
     * 根据商品id查询商品列表
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemsImg(String itemId);

    /**
     *根据商品id查询商品图片
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemsSpec(String itemId);

    /**
     *根据商品id查询商品参数
     * @param itemId
     * @return
     */
    public ItemsParam queryItemsParam(String itemId);


    /**
     *  根据商品id查询商品的评价
     * @param itemId
     */
    public CommentLevelCommensVo queryCommentCounts(String itemId);


}
