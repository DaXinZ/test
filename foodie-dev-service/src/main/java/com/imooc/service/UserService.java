package com.imooc.service;

import com.imooc.pojo.Stu;

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


}
