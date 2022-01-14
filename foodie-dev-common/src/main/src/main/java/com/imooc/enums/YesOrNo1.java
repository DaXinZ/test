package com.imooc.enums;

/**
 * Date: 2021/12/23 8:25 下午
 * Sex
 * Describe：
 * @Desc 性别 枚举
 */
public enum YesOrNo1 {
    NO(0,"否"),
    YES(1,"是");

    public  final  Integer type;
    public  final String valus;

    YesOrNo1(Integer type, String valus) {
        this.type = type;
        this.valus = valus;
    }
}
