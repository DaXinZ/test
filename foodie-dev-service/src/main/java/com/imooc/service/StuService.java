package com.imooc.service;

import com.imooc.pojo.Stu;
/**
 * Date: 2021/9/27 10:40 上午
 * StuService
 * Describe：
 */
public interface StuService {
    public Stu getStuinfo(int id);
    public void saveStu();
    public void updateStu(int id);
    public void deleteStu(int id);
}
