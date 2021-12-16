package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "items_img")
public class ItemsImg {
    /**
     * 图片主键
     */
    @Id
    private Integer id;

    /**
     * 商品外建id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * 顺序
     */
    private Integer sort;

    /**
     * 是否主图
     */
    @Column(name = "is_main")
    private Integer isMain;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 获取图片主键
     *
     * @return id - 图片主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置图片主键
     *
     * @param id 图片主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品外建id
     *
     * @return item_id - 商品外建id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置商品外建id
     *
     * @param itemId 商品外建id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取顺序
     *
     * @return sort - 顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置顺序
     *
     * @param sort 顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否主图
     *
     * @return is_main - 是否主图
     */
    public Integer getIsMain() {
        return isMain;
    }

    /**
     * 设置是否主图
     *
     * @param isMain 是否主图
     */
    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取图片地址
     *
     * @return url - 图片地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片地址
     *
     * @param url 图片地址
     */
    public void setUrl(String url) {
        this.url = url;
    }
}