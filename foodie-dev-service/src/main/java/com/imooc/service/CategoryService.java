package com.imooc.service;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import io.swagger.models.auth.In;
import org.apache.catalina.User;

import java.util.List;

/**
 * Date: 2022/3/15 2:20 下午
 * CarouseLService
 * Describe：
 */
public interface CategoryService {
    /**
     *  查询所有一级分类
     * @return
     */

    public List<Category> queryAllRootLevelCat ();


    /**
     *  根据一级分类id查询子分类信息
     * @param  rootCarId
     * @return
     */
    public List<CategoryVO> getSubCatList(Integer rootCarId);


    /**
     *  查询首页每个一级分类下的6条最新商品数据
     * @param  rootCarId
     * @return
     */
    public List<NewItemsVO>  getSixNewItemsLazy(Integer rootCarId);



}
