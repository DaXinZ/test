package com.imooc.pojo.vo;

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



    public void setqueryUsers(List<UsersVO> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "UsersVO{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", usersList=" + usersList +
                '}';
    }
}
