package com.imooc.service;

import bo.UserBo;
import com.imooc.pojo.Users;

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


}
