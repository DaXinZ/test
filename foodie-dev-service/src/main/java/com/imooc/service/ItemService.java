package com.imooc.service;

import com.imooc.pojo.*;

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
    public Items queryItemByid(String itemId);

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



}
