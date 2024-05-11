package com.imooc.pojo.vo;

import java.lang.ref.PhantomReference;
import java.util.List;

/**
 * 用户信息数据
 */

public class UsersVO {
    private String id;

    private String userName;
    private String nickName;
    private String createdTime;

    private Integer sex;

    private String password;

    private String newpassword;

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passowrd) {
        this.password = passowrd;
    }

    public List<UsersVO> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<UsersVO> usersList) {
        this.usersList = usersList;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }


    private List<UsersVO> usersList;


    public List<UsersVO> queryUsers() {
        return usersList;
    }


}
