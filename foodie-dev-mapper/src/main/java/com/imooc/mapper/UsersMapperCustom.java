package com.imooc.mapper;

import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.vo.UsersVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapperCustom {
    /**
     *
     * @param id
     * @return  查询用户信息
     */
    public List<UsersVO> queryUsers(String id);

}