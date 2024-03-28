package com.imooc.service.impl;


import com.imooc.mapper.ItemsImgMapper;
import com.imooc.mapper.ItemsMapper;
import com.imooc.mapper.ItemsParamMapper;
import com.imooc.mapper.ItemsSpecMapper;
import com.imooc.pojo.*;
import com.imooc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsImgMapper itemsImgMapper;
    @Autowired
    private ItemsSpecMapper itemsSpecMapper;
    @Autowired
    private ItemsParamMapper itemsParamMapper;



    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemsImg(String itemId) {
        Example itemsimgExp = new Example(ItemsImg.class);
        Example.Criteria criteria = itemsimgExp.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsImgMapper.selectByExample(itemsimgExp);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemsSpec(String itemId) {
        Example itemsSpecExp = new Example(ItemsImg.class);
        Example.Criteria criteria = itemsSpecExp.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsSpecMapper.selectByExample(itemsSpecExp);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryItemsParam(String itemId) {
        Example itemsParamExp = new Example(ItemsParam.class);
        Example.Criteria criteria = itemsParamExp.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsParamMapper.selectOneByExample(itemsParamExp);
    }
}
