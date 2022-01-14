package com.imooc.service;

import com.imooc.pojo.Carousel;

import java.util.List;

/**
 * Date: 2022/3/15 2:20 下午
 * CarouseLService
 * Describe：
 */
public interface CarouselService {
    /**
     *  查询所有轮播图列表
     * @param isShow
     * @return
     */

    public List<Carousel> queryAll(Integer isShow);


}
