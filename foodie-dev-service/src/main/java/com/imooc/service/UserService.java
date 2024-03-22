package com.imooc.service;

import bo.UserBo;
import com.imooc.pojo.Users;
import com.imooc.pojo.vo.UsersVO;

import java.util.List;

/**
 * Date: 2021/9/27 10:40 上午
 * StuService
 * Describe：
 */
public interface  UserService {
    /**
     * 判断用户名是否存在
     */
    public  boolean queryUsernameIsExist(String username);

    /**
     *
     * @param userBO
     * @return 注册接口
     */
    public Users createUser(UserBo userBO );

    /**
     *
     * @param username
     * @param password
     * @return 登录接口
     */
    public  Users queryUserForLogin(String username,String password);


    /**
     *
     * @param id
     * @return 判断用户id是否存在
     */
    public boolean  queryUserIdIsExist(String  id);

    /**
     *
     * @param nickname
     * @return 判断用户呢称是否存在
     */
    public boolean  queryUsernikenameIsExist(String nickname);


    /**
     * @param id
     * @return 查询用户信息
     */
    public List<UsersVO>  queryUsers(String id);

    /**
     * @param nickname
     * @return 模糊查询用户信息
     */
    public List<UsersVO>  queryUsername(String nickname);


}
