package com.imooc.utils;

import java.util.Arrays;
import java.util.Random;

public class RandomNickname {

    public    String RandomScale() {
        String[]  name = new String[]{"张","刘","陈","王","李","祝","赵","钱","周","吴","郑","冯","蒋","沈","韩","杨","朱","何","严","谢","彭","方","马","任","秦","吕","伍","余"
                ,"元","卜","顾","孟","祁","姚","贾","虞","丁","秋","慕容","欧阳","上官","司马","凌霄","皇甫","轩辕","东方","公户","公玉","公仪","梁丘","赫连"
                ,"澹台","宗政","司迁","司空","司寇","士孙","申屠","神行","太史","端木","诸葛"};
        String[]  nameto = new String[]{"八月","大新","晨曦","雨烟","星辰","雾海","凌霄","云舒","破晓","暗夜","流萤","幻柏","陌者","浅吻","孤影","落落","贪嗔","冷颜","沆砀","茶栀","苍老","终葵","娇气","娇气"
                ,"黛萱","约影","余夏","呦嘿","纞殇","暮雪","白狐","囍佳","奈川","芷香","梦漓","萧笙","迷情","碎梦","仙糖","吟月","夙浅","诗柔","初阳"
        ,"正","公","亮","懿","慈","木","阳","公","尉","铭","桑","仲文","仲","文","海","香","潇","云","暗","幻","月","末","魏"};
        Random random = new Random();

        int name1 = random.nextInt(name.length);

        int name2 = random.nextInt(nameto.length);

        String nameone = name[name1];
        String nameto2 = nameto[name2];
        String gather = nameone + nameto2;


        return gather;
    }




}
