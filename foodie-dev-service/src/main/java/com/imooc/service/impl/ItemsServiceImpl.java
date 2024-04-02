package com.imooc.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mapper.ItemsMapperCustom;
import com.imooc.pojo.vo.GetevaluateVO;
import com.imooc.service.ItemsService;
import com.imooc.utils.DesensitizationUtil;
import com.imooc.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapperCustom itemsCustomMapper;


    /**
     * 商品评价数据
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryGetevaluate(String itemId,Integer level,
                                                Integer page,Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId",itemId);
        map.put("level",level);

        PageHelper.startPage(page,pageSize);
        List<GetevaluateVO> list = itemsCustomMapper.queryGetevaluate(map);
        for (GetevaluateVO vo : list){
            vo.setNickname(DesensitizationUtil.commonDisplay(vo.getNickname()));

        }
        PageInfo<?> pagelist = new PageInfo<>(list);
        PagedGridResult  grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pagelist.getPages());
        grid.setRecords(pagelist.getTotal());

        return settpageGrod(list,page);
    }

    private PagedGridResult settpageGrod(List<?> list,Integer page){

        PageInfo<?> pagelist = new PageInfo<>(list);
        PagedGridResult  grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pagelist.getPages());
        grid.setRecords(pagelist.getTotal());
        return grid;
    }
}
