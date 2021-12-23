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

    public Users createUser(UserBo userBO );


}
