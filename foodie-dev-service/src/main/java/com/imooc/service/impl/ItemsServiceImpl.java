package com.imooc.service.impl;


import com.imooc.mapper.ItemsMapperCustom;
import com.imooc.pojo.vo.GetevaluateVO;
import com.imooc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapperCustom itemsCustomMapper;




    /**
     * 查询商品评价数据
     * @param itemId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<GetevaluateVO> queryGetevaluate(String itemId) {

        return itemsCustomMapper.queryGetevaluate(itemId);
    }
}
