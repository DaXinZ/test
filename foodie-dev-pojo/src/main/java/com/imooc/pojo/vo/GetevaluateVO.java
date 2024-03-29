package com.imooc.pojo.vo;


import java.util.List;

/**
 * 商品评级数据
 */
public class GetevaluateVO {

    private  Integer commentLevel;

    private String content;

    private String sepcName;

    private String createdTime;

    private String face;

    private String nickname;


    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSepcName() {
        return sepcName;
    }

    public void setSepcName(String sepcName) {
        this.sepcName = sepcName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }




    private List<GetevaluateVO> itemList;

    public List<GetevaluateVO> queryGetevaluate() {
        return itemList;
    }



    public void setGetevaluate(List<GetevaluateVO> itemList) {
        this.itemList = itemList;
    }
}
