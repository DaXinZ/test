package com.imooc.pojo.vo;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;

import java.util.List;

/**
 * 商品详情
 *
 * */
public class IteminfoVo {

    private Items item;
    private   List<ItemsImg> itemsImgList;
    private   List<ItemsSpec> itemSpecsList;
    private ItemsParam itemParam;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public List<ItemsImg> itemsImgList() {
        return itemsImgList;
    }

    public List<ItemsImg> getItemsImgList() {
        return itemsImgList;
    }

    public void setItemsImgList(List<ItemsImg> itemImg) {
        this.itemsImgList = itemImg;
    }

    public List<ItemsSpec> getItemSpecsList() {
        return itemSpecsList;
    }

    public void setItemSpecsList(List<ItemsSpec> itemSpecsList) {
        this.itemSpecsList = itemSpecsList;
    }

    public ItemsParam getItemParam() {
        return itemParam;
    }

    public void setItemParam(ItemsParam itemParam) {
        this.itemParam = itemParam;
    }

    @Override
    public String toString() {
        return "IteminfoVo{" +
                "item=" + item +
                ", itemsImgList=" + itemsImgList +
                ", itemSpecsList=" + itemSpecsList +
                ", itemParam=" + itemParam +
                '}';
    }


}
