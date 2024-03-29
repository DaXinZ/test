package com.imooc.service;


import com.imooc.pojo.vo.GetevaluateVO;

import java.util.List;

/**
 * Date: 2022/3/15 2:20 下午
 * CarouseLService
 * Describe：
 */
public interface ItemsService {


    /**
     * 查询商品评价数据
     * @param itemId
     * @return
     */
    public List<GetevaluateVO>   queryGetevaluate(String itemId);


}
