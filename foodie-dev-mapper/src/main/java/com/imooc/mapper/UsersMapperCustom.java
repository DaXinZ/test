package com.imooc.mapper;

import com.imooc.pojo.vo.UsersVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface UsersMapperCustom {
    /**
     *
     * @param id
     * @return  查询用户信息
     */
    public List<UsersVO> queryUsers(String id);


    /**
     *
     * @param  nikename
     * @return  根据用户昵称查询用户信息
     */
    public List<UsersVO>  queryUsername(String nikename);


    /**
     *  用户信息整合查询接口
     * @param id
     * @param nikename
     * @param username
     * @param sex
     * @param sort
     * @return
     */
    public List<UsersVO>  queryUsertow(@Param("pramsMap") Map<String, Object> map);


    /**
     * 修改用户密码接口
     *
     * @param id
     * @param password
     * @return
     */
    public Boolean   updetepassword(String id, String password, Date updatedtime);


    /**
     * 查询用户密码
     *
     * @param id
     * @return
     */

    public UsersVO querypassword(String  id);

}