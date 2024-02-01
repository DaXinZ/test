package com.imooc.service.impl;

import com.imooc.mapper.CarouseMapper;
import com.imooc.pojo.Carousel;
import com.imooc.service.CarouselService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Date: 2022/3/15 2:26 下午
 * CarouselServiceImpl
 * Describe：
 */
@Service
public class CarouselServiceImpl  implements CarouselService {
    @Autowired(required=false)
    private CarouseMapper carouseMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {

        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria  = example.createCriteria();
        criteria.andEqualTo("isShow",isShow);
        List<Carousel>  result =  carouseMapper.selectByExample(example);

     //   carouseMapper.select()


        return result;
    }
}
