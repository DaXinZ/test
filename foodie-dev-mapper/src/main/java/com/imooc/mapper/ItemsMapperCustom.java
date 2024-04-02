package com.imooc.mapper;

import com.imooc.pojo.vo.GetevaluateVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemsMapperCustom {
    /**
     * 查询评价相关数据
     * @param map
     * @return
     */
    public List<GetevaluateVO> queryGetevaluate(@Param("pramsMap") Map<String, Object> map);
}