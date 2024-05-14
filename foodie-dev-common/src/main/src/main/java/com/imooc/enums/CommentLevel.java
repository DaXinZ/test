package com.imooc.enums;

/**
 * Date: 2021/12/23 8:25 下午
 * Sex
 * Describe：
 * @Desc 性别 枚举
 */
public enum CommentLevel {
    GOOD(1,"好评"),
    NORML(2,"中评"),
    BAD(2,"差评");
    public  final  Integer type;
    public  final String valus;

    CommentLevel(Integer type, String valus) {
        this.type = type;
        this.valus = valus;
    }
}
