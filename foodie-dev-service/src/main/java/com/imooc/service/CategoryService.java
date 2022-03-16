package com.imooc.service;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;

import java.util.List;

/**
 * Date: 2022/3/15 2:20 下午
 * CarouseLService
 * Describe：
 */
public interface CategoryService {
    /**
     *  查询所有一级分类
     * @param
     * @return
     */

    public List<Category> queryAllRootLevelCat ();


}
