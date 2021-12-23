package com.imooc.enums;

/**
 * Date: 2021/12/23 8:25 下午
 * Sex
 * Describe：
 * @Desc 性别 枚举
 */
public enum Sex {
    wuman(0,"女"),
    man(1,"男"),
    secret(2,"保密");
    public  final  Integer type;
    public  final String valus;

    Sex(Integer type, String valus) {
        this.type = type;
        this.valus = valus;
    }
}
