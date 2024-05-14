package com.imooc.service;


import com.imooc.utils.PagedGridResult;

/**
 * Date: 2022/3/15 2:20 下午
 * CarouseLService
 * Describe：
 */
public interface ItemsService {


    /**
     * 根据商品id查询商品评价
     * @param itemId
     * @param level
     * @return
     */
    public PagedGridResult queryGetevaluate(String itemId, Integer level,
                                            Integer page, Integer pageSize);

    /**
     * 搜索商品列表
     *
     * @param catId
     * @param sort
     * @param pgae
     * @param pageSize
     * @return
     */
    public PagedGridResult queryItemsByKeywords(Integer catId, String sort, Integer page, Integer pageSize);


}
