package com.imooc.mapper;

import com.imooc.pojo.vo.GetevaluateVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemsMapperCustom {
    /**
     * 查询评价相关数据
     * @param itemId
     * @return
     */
    public List<GetevaluateVO> queryGetevaluate(String itemId);
}