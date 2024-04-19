package com.imooc.service.impl;


import com.github.pagehelper.PageHelper;
import com.imooc.enums.CommentLevel;
import com.imooc.mapper.*;
import com.imooc.pojo.*;
import com.imooc.pojo.vo.CommentLevelCommensVo;
import com.imooc.pojo.vo.commodityVo;
import com.imooc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;



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


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CommentLevelCommensVo queryCommentCounts(String itemId) {

        Integer goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type);
        Integer noramlCounts = getCommentCounts(itemId, CommentLevel.NORML.type);
        Integer badCounts = getCommentCounts(itemId, CommentLevel.BAD.type);
        Integer totalCounts = goodCounts+noramlCounts+badCounts;

        CommentLevelCommensVo commensVo  = new CommentLevelCommensVo();
        commensVo.setTotalCounts(totalCounts);
        commensVo.setGoodCounts(goodCounts);
        commensVo.setNormalCounts(noramlCounts);
        commensVo.setBadCounts(badCounts);

        return commensVo;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    Integer getCommentCounts(String itemId,Integer level){
        ItemsComments  conditon = new ItemsComments();
        conditon.setItemId(itemId);
        if (level != null){
            conditon.setCommentLevel(level);
        }


        return  itemsCommentsMapper.selectCount(conditon);
    }
}
